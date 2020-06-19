package Persistencia;

import Carro.Carro;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * 
 */
public class DAOCarro implements DAO<Carro> {

    @Override
    public Carro buscar(Carro t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carro> buscarMultiplos(String filtro) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Carro> buscarTodos() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Carro inserir(Carro t) throws SQLException {
        
        String sql = "INSERT INTO carro (placa) VALUES(?)";
        PreparedStatement pst;
        
        pst = Banco.getConexao().prepareStatement(sql);
        
        pst.setString(1, t.getPlaca());
        
        int res = pst.executeUpdate();
       
        return t;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Carro t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Carro atualizar(Carro t) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
