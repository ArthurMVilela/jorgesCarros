package API;

import com.sun.net.httpserver.HttpExchange;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Util {
    public static void escreverResposta(HttpExchange he, String corpo) throws IOException {
        he.getResponseHeaders().set("Content-Type", "application/json");
        he.sendResponseHeaders(200, corpo.length());
        OutputStream os = he.getResponseBody();
        os.write(corpo.getBytes());
        os.close();
    }
    
    public static void escreverRespostaErro(HttpExchange he, String erro) throws IOException {
        String corpo = "{\"erro\":\"" + erro + "\"}";
        
        he.getResponseHeaders().set("Content-Type", "application/json");
        he.sendResponseHeaders(200, corpo.length());
        OutputStream os = he.getResponseBody();
        os.write(corpo.getBytes());
        os.close();
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
