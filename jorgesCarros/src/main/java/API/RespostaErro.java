/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

/**
 * Representa uma resposta de erro a uma requisição HTTP
 */
public class RespostaErro {
    private String mensagem;

    public RespostaErro() {
    }

    public RespostaErro(String mensagem) {
        this.mensagem = mensagem;
    }
    
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    
}
