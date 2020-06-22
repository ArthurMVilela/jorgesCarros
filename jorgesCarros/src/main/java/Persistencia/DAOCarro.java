package Persistencia;

import Carro.Carro;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * 
 */
public class DAOCarro implements DAO<Carro> {

    @Override
    public Carro buscar(Carro t) throws SQLException {
        String sql = "SELECT * FROM carro WHERE codigo = ?";
        PreparedStatement pst;
        ResultSet rs;
        
        Carro c = null;
        
        pst = Banco.getConexao().prepareStatement(sql);
        
        pst.setInt(1, t.getCodigo());
        
        rs = pst.executeQuery();
        
        if (rs.next()) {
            c = new Carro();
            
            c.setCodigo(rs.getInt("codigo"));
            c.setPlaca(rs.getString("placa"));
        } 
        
        return c;
        
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
