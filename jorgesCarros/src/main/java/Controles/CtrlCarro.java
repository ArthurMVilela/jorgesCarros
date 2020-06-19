package Controles;

import Carro.Carro;
import Carro.StatusCarro;

/**
 * Classe controle para todas as operações envolvendo o 
 * pacote Carro e persitencia de dados de entidades do
 * pacote Carro.
 */
public class CtrlCarro {
    
    /**
     * Adiciona o carro ao banco de dados e retorna o veículo
     * já cadastrado no sistema.
     * 
     * @param carro     carro a ser cadastrado
     * @return          carro cadastrado
     */
    public Carro adicionarCarro(Carro carro) {
        return new Carro();
    }
    
    /**
     * Busca um carro no banco de dados.
     * 
     * @param codigo    código do carro
     * @return          carro cadastrado no sistema
     */
    public Carro buscarCarro(int codigo) {
        return new Carro();
    }
    
    /**
     * Altera os dados de um carro com um código especifico.
     * 
     * @param codigo    código do carro a ser alterado
     * @param carro     carro com os dados alterados
     * @return          Carro com os dados alterados com successo
     */
    public Carro alterarCarro(int codigo, Carro carro) {
        return new Carro();
    }
    
    /**
     * Exclui um carro do banco de dados
     * 
     * @param codigo    código do veículo a ser excluido
     * @return          se o veiculo foi excluir
     */    
    public boolean excluirCarro(int codigo) {
        return false;
    }
    
    /**
     * Muda o status de um carro com um código específico
     * 
     * @param codigo    código do carro
     * @param status    novo status do caroo
     * @return          carro com status já alterado
     */   
    public Carro mudarStatus(int codigo, StatusCarro status){
        return new Carro();
    }
}
