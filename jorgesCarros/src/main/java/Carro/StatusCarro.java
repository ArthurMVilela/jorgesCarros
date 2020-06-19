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
    Disponivel,         //está disponivel para aluguel
    EmManutencao,       //em manutenção   
    EmServico,          //em serviço de terceiro
    Reservado,          //reservado para aluguél
    RemovidoDaGaragem,  //não mais em posse da empresa
    Alugado             //alugado e em mão do cliente
}
