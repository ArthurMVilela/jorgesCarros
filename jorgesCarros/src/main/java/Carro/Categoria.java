/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

/**
 * Descreve a categória de um Carro
 */
public enum Categoria {
    Utilitario(0),Sedan(1),QuatroPorQuatro(2);
    
    private final int valor;
    Categoria(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return valor;
    }
}
