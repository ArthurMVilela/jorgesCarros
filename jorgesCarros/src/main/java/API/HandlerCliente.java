package API;

import java.io.IOException;
import java.util.List;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import Cliente.Cliente;
import Controles.FacadeCtrl;

/**
 * Processa todas as requisições HTTP feitas para /clientes
 */
public class HandlerCliente implements HttpHandler {
    
    FacadeCtrl ctrl = new FacadeCtrl();

    @Override
    public void handle(HttpExchange he) throws IOException {
        String path = he.getRequestURI().getPath();
        String[] pathSegmentos = path.split("/");
        
        System.out.print(he.getRequestMethod());
        
       // Util.escreverRespostaErro(he, "Não implementado");
        

        if (he.getRequestMethod().equals("GET")) {
            switch (pathSegmentos.length) {
                
                //busca de clientes
                 
                case 2: { 
                   
                    //listar todos os clientes
                    
                    List<Cliente> clientes;

                    clientes = ctrl.getCliente().buscarTodos();
                    
                    String corpoResposta = ctrl.getCliente().transformarJSON(clientes);
                    
                    Util.escreverResposta(he, 200, corpoResposta);
                    break;
                }
                
                //busca um cliente especifico por cpf
                case 3: { 
                    
                    //pegar cpf na URI
                    String cpf;
                    try {
                        cpf = String.valueOf(pathSegmentos[pathSegmentos.length-1]);
                    } catch (Exception ex) {
                        Util.escreverRespostaErro(he, 400, "Requisição contém erro. CPF Invalido");
                        return;
                    }
                    
                    Cliente cliente = ctrl.getCliente().buscarCliente(cpf);
                    
                    String corpoResposta = ctrl.getCliente().transformarJSON(cliente);
                    
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
            //cadastrar novo cliente
            
            //le o corpo da requisição e transforma em uma string
            String corpo = Util.lerCorpo(he.getRequestBody());
            
            if (corpo == "") {
                Util.escreverRespostaErro(he, 400, "Requisição incompleta. Falta corpo.");
                return;
            }
            
            //transforma o cropo em um objeto Cliente
            Cliente cliente = ctrl.getCliente().lerJSON(corpo);
            Cliente registrado = ctrl.getCliente().adicionarCliente(cliente); //registra cliente e retorna ele registrado
            String corpoResposta = ctrl.getCliente().transformarJSON(registrado); //transforma o cliente registrado em uma string
            
            //escreve a resposta
            Util.escreverResposta(he, 201, corpoResposta);
            return;
            
        } else if (he.getRequestMethod().equals("DELETE")) {
            //deletar cliente especifico
            if (pathSegmentos.length == 3) {
                //pegar cpf na URI
                String cpf;
                try {
                    cpf = String.valueOf(pathSegmentos[pathSegmentos.length-1]);
                } catch (Exception ex) {
                    Util.escreverRespostaErro(he, 400, "Requisição contem erros. CPF Invalido");
                    return;
                }
                
                boolean deletado = ctrl.getCliente().excluirCliente(cpf);
                
                if (deletado) {
                     Util.escreverResposta(he, 200, "Ok");
                } else {
                    Util.escreverRespostaErro(he, 404, "Não encontrado.");
                }
                
            } else {
            	
                //chamar mensagem de erro
                Util.escreverRespostaErro(he, 404, "Não encontrado.");
            }
        	
        } else if (he.getRequestMethod().equals("UPDATE")) {
 
        	//atualizar dados de cliente especifico
        	
            if (pathSegmentos.length == 2) {
                
                //ler corpo
                String corpo = Util.lerCorpo(he.getRequestBody());
                if (corpo == "") {
                    Util.escreverRespostaErro(he, 400, "Requisição contem erros. Falta corpo.");
                    return;
                }
                
                //transforma o corpo em um objeto Cliente
                Cliente cliente = ctrl.getCliente().lerJSON(corpo);              
                Cliente alterado = ctrl.getCliente().alterarCliente(cliente); //registra cliente e retorna ele registrado
                
                
                if (alterado == null) {
                    Util.escreverRespostaErro(he, 400, "Requisição contem erro. Nenhum cliente com este cpf.");
                    return;
                }
                
                String corpoResposta = ctrl.getCliente().transformarJSON(alterado); //transforma o cliente registrado em uma string
                
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
