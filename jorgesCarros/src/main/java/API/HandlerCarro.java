package API;

import Carro.Carro;
import Controles.FacadeCtrl;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;

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
        
       // Util.escreverRespostaErro(he, "Não implementado");
        

        if (he.getRequestMethod().equals("GET")) {
            switch (pathSegmentos.length) {
                case 2: { // /carros
                    //listar todos os carros
                    List<Carro> carros;
                    
                    carros = ctrl.getCarro().buscarTodos();
                    
                    String corpoResposta = ctrl.getCarro().transformarJSON(carros);
                    
                    Util.escreverResposta(he, 200, corpoResposta);
                    break;
                }
                case 3: { // /carros/{codigo}
                    //um carro especifico
                    
                    //pegar codigo na URI
                    int cod;
                    try {
                        cod = Integer.valueOf(pathSegmentos[pathSegmentos.length-1]);
                    } catch (Exception ex) {
                        Util.escreverRespostaErro(he, 400, "Requisição mal feita. Código Invalido");
                        return;
                    }
                    
                    Carro c = ctrl.getCarro().buscarCarro(cod);
                    
                    String corpoResposta = ctrl.getCarro().transformarJSON(c);
                    
                    //escreve a resposta
                    Util.escreverResposta(he, 200, corpoResposta);
                    
                    break;
                }
                default: {
                    //chamar resposta erro
                    Util.escreverRespostaErro(he, 404, "Não encontrado.");
                }
            }
            
            return;            
        } else if (he.getRequestMethod().equals("POST")) {
            //cadastrar novo carro
            
            //le o corpo da requisição e transforma em uma string
            String corpo = Util.lerCorpo(he.getRequestBody());
            
            if (corpo == "") {
                Util.escreverRespostaErro(he, 400, "Requisição mal feita. Falta corpo.");
                return;
            }
            
            //transforma o cropo em um objeto Carro
            Carro c = ctrl.getCarro().lerJSON(corpo);
            Carro registrado = ctrl.getCarro().adicionarCarro(c); //registra carro e retorna ele registrado
            String corpoResposta = ctrl.getCarro().transformarJSON(registrado); //transforma o carro registrado em uma string
            
            //escreve a resposta
            Util.escreverResposta(he, 201, corpoResposta);
            return;
        } else if (he.getRequestMethod().equals("DELETE")) {
            //deletar carro especifico
            if (pathSegmentos.length == 3) {
                //pegar codigo na URI
                int cod;
                try {
                    cod = Integer.valueOf(pathSegmentos[pathSegmentos.length-1]);
                } catch (Exception ex) {
                    Util.escreverRespostaErro(he, 400, "Requisição mal feita. Código Invalido");
                    return;
                }
                
                boolean deletado = ctrl.getCarro().excluirCarro(cod);
                
                if (deletado) {
                     Util.escreverResposta(he, 204, "");
                } else {
                    Util.escreverRespostaErro(he, 404, "Não encontrado.");
                }
                
            } else {
                //chamar mensagem de erro
                Util.escreverRespostaErro(he, 404, "Não encontrado.");
            }
        } else if (he.getRequestMethod().equals("PATCH")) {
            //atualizar dados de carro especifico
            if (pathSegmentos.length == 3) {
                //pegar codigo na URI
                int cod;
                try {
                    cod = Integer.valueOf(pathSegmentos[pathSegmentos.length-1]);
                } catch (Exception ex) {
                    Util.escreverRespostaErro(he, 400, "Requisição mal feita. Código Invalido");
                    return;
                }
                
                //ler corpo
                String corpo = Util.lerCorpo(he.getRequestBody());
                if (corpo == "") {
                    Util.escreverRespostaErro(he, 400, "Requisição mal feita. Falta corpo.");
                    return;
                }
                
                //transforma o cropo em um objeto Carro
                Carro c = ctrl.getCarro().lerJSON(corpo);              
                Carro alterado = ctrl.getCarro().alterarCarro(cod, c); //registra carro e retorna ele registrado
                
                
                if (alterado == null) {
                    Util.escreverRespostaErro(he, 400, "Requisição mal feita. Nenhum carro com este código.");
                    return;
                }
                
                String corpoResposta = ctrl.getCarro().transformarJSON(alterado); //transforma o carro registrado em uma string
                
                //escreve a resposta
                Util.escreverResposta(he, 201, corpoResposta);
            } else {
                //chamar resposta erro
                    Util.escreverRespostaErro(he, 404, "Não encontrado.");
            }
        } else {
            //chamar resposta erro
            Util.escreverRespostaErro(he, 404, "Não encontrado.");
        }
    }
    
}
