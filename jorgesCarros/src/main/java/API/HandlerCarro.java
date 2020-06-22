package API;

import Carro.Carro;
import Persistencia.FacadeDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Processa todas as requisições HTTP feitas para /carros
 */
public class HandlerCarro implements HttpHandler {
    
    private FacadeDAO dao = new FacadeDAO();

    @Override
    public void handle(HttpExchange he) throws IOException {
        if (he.getRequestMethod().equals("GET")) {
            Carro c = new Carro();
            
            c.setCodigo(1);
            
            String corpoResposta = "";
            
            try {
                
                 ObjectMapper mapper = new ObjectMapper();
                 
                Carro c2 = dao.getCarro().buscar(c);
                corpoResposta = mapper.writeValueAsString(c2);
                
            } catch (SQLException ex) {
                Logger.getLogger(HandlerCarro.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            he.getResponseHeaders().set("Content-Type", "application/json");
            he.sendResponseHeaders(200, corpoResposta.length());
            OutputStream os = he.getResponseBody();
            os.write(corpoResposta.getBytes());
            os.close();
        } else {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
        
    }
    
}
