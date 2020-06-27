/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Carro;

/**
 * Representa o status de um carro, ou seja, se ele está
 * diponivel ou não, em manutenção, fora da empresa, alugado
 * etc
 */
public enum StatusCarro {
    Disponivel(0),EmManutencao(1),EmServico(2),Reservado(3),RemovidoDaGaragem(4),Alugado(5);            

    private final int valor;
    StatusCarro(int valor){
        this.valor = valor;
    }
    public int getValor(){
        return valor;
    }
}
