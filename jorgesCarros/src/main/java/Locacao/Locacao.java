package Locacao;

import Carro.Carro;
import Cliente.Cliente;
import java.time.LocalDate;

/**
 * Representa os dados de uma locação de um carro.
 */
public class Locacao {
    private int codigo;
    private LocalDate dataRetiradaReservada, dataDevolucaoReservada;
    private Carro carro;
    private Cliente cliente;
    private Retirada retirada;
    private Devolucao devolucao;

    public Locacao() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public LocalDate getDataRetiradaReservada() {
        return dataRetiradaReservada;
    }

    public void setDataRetiradaReservada(LocalDate dataRetiradaReservada) {
        this.dataRetiradaReservada = dataRetiradaReservada;
    }

    public LocalDate getDataDevolucaoReservada() {
        return dataDevolucaoReservada;
    }

    public void setDataDevolucaoReservada(LocalDate dataDevolucaoReservada) {
        this.dataDevolucaoReservada = dataDevolucaoReservada;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Retirada getRetirada() {
        return retirada;
    }

    public void setRetirada(Retirada retirada) {
        this.retirada = retirada;
    }

    public Devolucao getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Devolucao devolucao) {
        this.devolucao = devolucao;
    }
    
    
}
