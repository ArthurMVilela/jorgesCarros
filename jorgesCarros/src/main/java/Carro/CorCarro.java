/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

/**
 * Representa a cor de um carro, não subdividindo em tons.
 */
public enum CorCarro {
    Amarelo(0),Azul(1),Bege(2),Branco(3),Cinza(4),Laranja(5),Marrom(6),Preto(7),Verde(8),Vermelho(9);
    
    private final int valor;
    CorCarro(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return valor;
    }
}
