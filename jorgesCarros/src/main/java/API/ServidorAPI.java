package API;

import Carro.Carro;
import Persistencia.Banco;
import Persistencia.DAOCarro;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.sql.SQLException;

/**
 * Está classes roda um servidor uma API REST que serve os
 * recursos do sistemas por HTTP 
 */
public class ServidorAPI {
    public static void main(String[] args) throws SQLException{
        
        Banco.abrir();
                
        try {
            //cria o servidor e atribui a ele a porta 8080 do localhost
            HttpServer servidor = HttpServer.create(new InetSocketAddress("localhost", 8080), 0);
            
            servidor.createContext("/carros", new HandlerCarro());
                        
            //começa o servidor
            servidor.setExecutor(null); 
            servidor.start();
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }
}
