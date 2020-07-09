package API;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Util {
    public static void escreverResposta(HttpExchange he, int codigo, String corpo) throws IOException {
        he.getResponseHeaders().set("Content-Type", "application/json");
        he.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        he.sendResponseHeaders(codigo, corpo.getBytes().length);
        OutputStream os = he.getResponseBody();
        os.write(corpo.getBytes());
        os.close();
    }
    
    public static void escreverRespostaErro(HttpExchange he, int codigo, String erro) throws IOException {
        RespostaErro res = new RespostaErro(erro);
        
        ObjectMapper mapper = new ObjectMapper();
        String json;
        
        try {
            json = mapper.writeValueAsString(res);
            
            he.getResponseHeaders().set("Content-Type", "application/json");
            he.sendResponseHeaders(codigo, json.length());
            OutputStream os = he.getResponseBody();
            os.write(json.getBytes());
            os.close();
        } catch (Exception ex) {
            he.sendResponseHeaders(500, 0);
            OutputStream os = he.getResponseBody();
            os.close();
        }
    }
    
    public static String lerCorpo(InputStream is) {
        String corpo = "";

        InputStreamReader reader = new InputStreamReader(is);
        BufferedReader readerComBuff = new BufferedReader(reader);
        StringBuffer sb = new StringBuffer();
        String s;

        if (is != null) {
            try {
                while ((s = readerComBuff.readLine()) != null) {
                    sb.append(s);
                }
                corpo = sb.toString();
            } catch (Exception ex) {
                corpo = "";
            }
        }
        
        return corpo;
    }
}
