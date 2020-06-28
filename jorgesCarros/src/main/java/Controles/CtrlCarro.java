package Controles;

import Carro.Carro;
import Carro.StatusCarro;
import Persistencia.FacadeDAO;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Classe controle para todas as operações envolvendo o 
 * pacote Carro e persitencia de dados de entidades do
 * pacote Carro.
 */
public class CtrlCarro {
    
    private FacadeDAO dao = new FacadeDAO();
    
    /**
     * Adiciona o carro ao banco de dados e retorna o veículo
     * já cadastrado no sistema.
     * 
     * @param carro     carro a ser cadastrado
     * @return          carro cadastrado
     */
    public Carro adicionarCarro(Carro carro) {
        
        Carro c;
        try {
            c = dao.getCarro().inserir(carro);
        } catch (SQLException ex) {
            c = null;
        }
        
        return c;
    }
    
    /**
     * Busca um carro no banco de dados.
     * 
     * @param codigo    código do carro
     * @return          carro cadastrado no sistema
     */
    public Carro buscarCarro(int codigo) {
        Carro c = new Carro();
        c.setCodigo(codigo);

        try {
            c = dao.getCarro().buscar(c);
        } catch (SQLException ex) {
            c = null;
        }
                
        return c;
    }
    
    /**
     * Busca todos carros no banco de dados.
     * 
     * @return          carros cadastrados no sistema
     */
    public List<Carro> buscarTodos() {
        List<Carro> carros;

        try {
            carros = dao.getCarro().buscarTodos();
        } catch (SQLException ex) {
            carros = null;
        }
                
        return carros;
    }
    
    
    /**
     * Altera os dados de um carro com um código especifico.
     * 
     * @param codigo    código do carro a ser alterado
     * @param carro     carro com os dados alterados
     * @return          Carro com os dados alterados com successo
     */
    public Carro alterarCarro(int codigo, Carro carro) {
        Carro c;
        
        carro.setCodigo(codigo);
        
        try {
            c = dao.getCarro().atualizar(carro);
        } catch (SQLException ex) {
            c = null;
        }
        
        return c;
    }
    
    /**
     * Exclui um carro do banco de dados
     * 
     * @param codigo    código do veículo a ser excluido
     * @return          se o veiculo foi excluir
     */    
    public boolean excluirCarro(int codigo) {
        Carro c = new Carro();
        boolean res;
        
        c.setCodigo(codigo);
        
        try {
            res = dao.getCarro().excluir(c);
        } catch (SQLException ex) {
            res = false;
        }
        
        return res;
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
    
    public Carro lerJSON(String json) {
        ObjectMapper mapper = new ObjectMapper();
        Carro c = new Carro();
        try {
            c = mapper.readValue(json, Carro.class);
        } catch (IOException ex) {
            
            c = null;
        }
        
        return c;
    }
    
    public String transformarJSON(Carro c) {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        
        try {
            json = mapper.writeValueAsString(c);
        } catch (Exception ex) {
            json = "";
        }
        
        return json;
    }
    
    public String transformarJSON(List<Carro> c) {
        ObjectMapper mapper = new ObjectMapper();
        String json;
        
        try {
            json = mapper.writeValueAsString(c);
        } catch (Exception ex) {
            json = "";
        }
        
        return json;
    }
}
