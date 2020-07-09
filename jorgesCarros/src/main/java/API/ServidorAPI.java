package API;

import Persistencia.Banco;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Está classes roda um servidor uma API REST que serve os
 * recursos do sistemas por HTTP 
 */
public class ServidorAPI {
    public static void main(String[] args){
        
    	//Locale.setDefault(new Locale("pt", "BR"));
    	//System.out.println(Locale.getDefault());
    	
        try {
            Banco.abrir();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
                
        try {
            //cria o servidor e atribui a ele a porta 8080 do localhost
            HttpServer servidor = HttpServer.create(new InetSocketAddress("localhost", 4000), 0);
            
            servidor.createContext("/carros", new HandlerCarro());
            
            servidor.createContext("/cliente", new HandlerCliente());
            
            
            //começa o servidor
            servidor.setExecutor(null); 
            servidor.start();
            
            System.out.print("Servidor pronto.");
        } catch (IOException ex) {
            System.out.println(ex);
            try {
                Banco.fechar();
            } catch (SQLException ex1) {
                System.out.println(ex);
            }
        }
    }
}
