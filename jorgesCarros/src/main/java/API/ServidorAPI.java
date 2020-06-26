package API;

import Persistencia.Banco;
import com.sun.net.httpserver.HttpServer;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.sql.SQLException;

/**
 * Está classes roda um servidor uma API REST que serve os
 * recursos do sistemas por HTTP 
 */
public class ServidorAPI {
    public static void main(String[] args){
        System.out.print("AAAAAAAAAAAA");
        
        try {
            Banco.abrir();
        } catch (SQLException ex) {
            System.out.println(ex);
        }
                
        try {
            //cria o servidor e atribui a ele a porta 8080 do localhost
            HttpServer servidor = HttpServer.create(new InetSocketAddress("localhost", 4000), 0);
            
            servidor.createContext("/carros", new HandlerCarro());
            System.out.print("AAAAAAAAAAAA");
            
            //começa o servidor
            servidor.setExecutor(null); 
            servidor.start();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
