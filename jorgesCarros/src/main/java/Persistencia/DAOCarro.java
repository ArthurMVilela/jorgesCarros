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
            c.setRenavam(rs.getString("renavam"));
            //enum
            c.setModelo(rs.getString("modelo"));
            c.setAno(rs.getInt("ano"));
            c.setMarca(rs.getString("marca"));
            c.setKmLitro(rs.getFloat("km_litro"));
            c.setVolumeTanque(rs.getInt("volume_tanque"));
            c.setArCondicionado(rs.getInt("ar_condicionado")==1);
            c.setGps(rs.getInt("gps")==1);
            c.setDirecaoAutomatica(rs.getInt("direcao_automatica")==1);
            c.setRadioBluetooth(rs.getInt("radio_bluetooth")==1);
            
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
        
        String sql = "INSERT INTO carro (placa) VALUES (?)";
        PreparedStatement pst;
        
        pst = Banco.getConexao().prepareStatement(sql);
        
        pst.setString(1, t.getPlaca());
//        pst.setString(2, t.getRenavam());
//        pst.setString(3, t.getModelo());
//        pst.setInt(4, t.getStatus().ordinal());
//        pst.setInt(5, t.getCategoria().ordinal());
//        pst.setInt(6, t.getTipoMotor().ordinal());
//        pst.setInt(7, t.getCor().ordinal());
//        pst.setString(8, t.getModelo());
//        pst.setInt(9, t.getAno());
//        pst.setString(10, t.getMarca());
//        pst.setFloat(11, t.getKmLitro());
//        pst.setInt(12, t.getVolumeTanque());
//        if (t.isArCondicionado()){
//            pst.setInt(13, 1);
//        } else {
//            pst.setInt(13, 0);
//        }
//        
//        if (t.isGps()){
//            pst.setInt(14, 1);
//        } else {
//            pst.setInt(14, 0);
//        }
//        
//        if (t.isDirecaoAutomatica()){
//            pst.setInt(15, 1);
//        } else {
//            pst.setInt(15, 0);
//        }
//        
//        if (t.isRadioBluetooth()){
//            pst.setInt(16, 1);
//        } else {
//            pst.setInt(16, 0);
//        }
        
        pst.executeUpdate();
       
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
