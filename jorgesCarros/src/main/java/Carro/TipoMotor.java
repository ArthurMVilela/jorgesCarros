/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

/**
 * Descreve o tipo de motor de um carro.
 */
public enum TipoMotor {
    Motor1_0(0),Motor1_4(1),Motor1_6(2),Motor1_8(3),Motor2_0(4);
    
    private final int valor;
    TipoMotor(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return valor;
    }
}
