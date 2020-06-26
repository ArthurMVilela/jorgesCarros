package API;

import Carro.Carro;
import Controles.FacadeCtrl;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * Processa todas as requisições HTTP feitas para /carros
 */
public class HandlerCarro implements HttpHandler {
    
    FacadeCtrl ctrl = new FacadeCtrl();

    @Override
    public void handle(HttpExchange he) throws IOException {
        String path = he.getRequestURI().getPath();
        String[] pathSegmentos = path.split("/");
        
        System.out.print(he.getRequestMethod());

        if (he.getRequestMethod().equals("GET")) {
            switch (pathSegmentos.length) {
                case 2: { // /carros
                    //listar todos os carros
                    break;
                }
                case 3: { // /carros/{codigo}
                    //um carro especifico
                    break;
                }
                default: {
                    //chamar resposta erro
                    
                }
            }
            
        } else if (he.getRequestMethod().equals("POST")) {
//            //cadastrar novo carro
//            System.out.print("POST");
//            InputStream is = he.getRequestBody();
//            InputStreamReader reader = new InputStreamReader(is);
//            BufferedReader readerComBuff = new BufferedReader(reader);
//            StringBuffer sb = new StringBuffer();
//            String s;
//            String corpo = "";
//
//            if (is != null) {
//                try {
//                    while ((s = readerComBuff.readLine()) != null) {
//                        sb.append(s);
//                    }
//                    corpo = sb.toString();
//                } catch (Exception ex) {
//                    corpo = "";
//                }
//            }
//            ObjectMapper mapper = new ObjectMapper();
//           
//            Carro c = mapper.readValue(corpo, Carro.class);
//            ctrl.getCarro().adicionarCarro(c);
//            String corpoResposta = mapper.writeValueAsString(c);
//            
//            he.getResponseHeaders().set("Content-Type", "application/json");
//            he.sendResponseHeaders(200, corpo.length());
//            OutputStream os = he.getResponseBody();
//            os.write(corpo.getBytes());
//            os.close();
//            
        } else if (he.getRequestMethod().equals("DELETE")) {
            //deletar carro especifico
            if (pathSegmentos.length == 3) {
                
            } else {
                //chamar mensagem de erro
            }
        } else if (he.getRequestMethod().equals("UPDATE")) {
            //atualizar dados de carro especifico
            if (pathSegmentos.length == 3) {
                
            } else {
                //chamar mensagem de erro
            }
        } else {
            //chamar resposta erro
        }
    }
    
}
