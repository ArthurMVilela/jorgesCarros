package API;

import Persistencia.FacadeDAO;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;

/**
 * Processa todas as requisições HTTP feitas para /carros
 */
public class HandlerCarro implements HttpHandler {
    
    private FacadeDAO dao = new FacadeDAO();

    @Override
    public void handle(HttpExchange he) throws IOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
