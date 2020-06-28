package Persistencia;

import Carro.Carro;
import Carro.Categoria;
import Carro.CorCarro;
import Carro.StatusCarro;
import Carro.TipoMotor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
                        
            c.setStatus(StatusCarro.values()[rs.getInt("status")]);
            c.setCategoria(Categoria.values()[rs.getInt("categoria")]);
            c.setTipoMotor(TipoMotor.values()[rs.getInt("tipo_motor")]);
            c.setCor(CorCarro.values()[rs.getInt("cor")]);
            
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
        List<Carro> carros = new ArrayList();
        Carro c;
        
        String sql = "SELECT * FROM carro";
        PreparedStatement pst;
        ResultSet rs;
        
        pst = Banco.getConexao().prepareStatement(sql);
        
        rs = pst.executeQuery();
        
        while(rs.next()) {
            c = new Carro();
            
            c.setCodigo(rs.getInt("codigo"));
            c.setPlaca(rs.getString("placa"));
            c.setRenavam(rs.getString("renavam"));
                        
            c.setStatus(StatusCarro.values()[rs.getInt("status")]);
            c.setCategoria(Categoria.values()[rs.getInt("categoria")]);
            c.setTipoMotor(TipoMotor.values()[rs.getInt("tipo_motor")]);
            c.setCor(CorCarro.values()[rs.getInt("cor")]);
            
            c.setModelo(rs.getString("modelo"));
            c.setAno(rs.getInt("ano"));
            c.setMarca(rs.getString("marca"));
            c.setKmLitro(rs.getFloat("km_litro"));
            c.setVolumeTanque(rs.getInt("volume_tanque"));
            c.setArCondicionado(rs.getInt("ar_condicionado")==1);
            c.setGps(rs.getInt("gps")==1);
            c.setDirecaoAutomatica(rs.getInt("direcao_automatica")==1);
            c.setRadioBluetooth(rs.getInt("radio_bluetooth")==1);
            
            carros.add(c);
        }
              
        
        return carros;
    }

    @Override
    public Carro inserir(Carro t) throws SQLException {
        
        String sql = "INSERT INTO carro "
                + "(placa,renavam,status,categoria,tipo_motor,cor,modelo,ano,marca,"
                + "km_litro,volume_tanque,ar_condicionado,gps,direcao_automatica,"
                + "radio_bluetooth)"
                + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        
//        String sql = "INSERT INTO carro "
//                + "(placa,renavam,status)"
//                + " VALUES (?,?,?)";
        PreparedStatement pst;
        ResultSet rs;
        
        pst = Banco.getConexao().prepareStatement(sql);
        
        pst.setString(1, t.getPlaca());
        pst.setString(2, t.getRenavam());
        pst.setInt(3, t.getStatus().getValor());
        pst.setInt(4, t.getCategoria().getValor());
        pst.setInt(5, t.getTipoMotor().getValor());
        pst.setInt(6, t.getCor().getValor());
        pst.setString(7, t.getModelo());
        pst.setInt(8, t.getAno());
        pst.setString(9, t.getMarca());
        pst.setFloat(10, t.getKmLitro());
        pst.setInt(11, t.getVolumeTanque());
        if (t.isArCondicionado()){
            pst.setInt(12, 1);
        } else {
            pst.setInt(12, 0);
        }
        
        if (t.isGps()){
            pst.setInt(13, 1);
        } else {
            pst.setInt(13, 0);
        }
        
        if (t.isDirecaoAutomatica()){
            pst.setInt(14, 1);
        } else {
            pst.setInt(14, 0);
        }
        
        if (t.isRadioBluetooth()){
            pst.setInt(15, 1);
        } else {
            pst.setInt(15, 0);
        }
        
        pst.executeUpdate();
        
        pst = Banco.getConexao().prepareStatement("SELECT MAX(codigo) FROM carro");
        rs = pst.executeQuery();
        rs.next();
        
        Carro registrado = new Carro();
        
        registrado.setCodigo(rs.getInt("MAX(codigo)"));
        
        registrado = this.buscar(registrado);
       
        return registrado;
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean excluir(Carro t) throws SQLException {
        String sql = "DELETE FROM carro WHERE codigo = ?";
        PreparedStatement pst;
        
        pst = Banco.getConexao().prepareStatement(sql);
        pst.setInt(1, t.getCodigo());
        
        int res = pst.executeUpdate();
        
        return res!=0;
    }

    @Override
    public Carro atualizar(Carro t) throws SQLException {
        String sql = "UPDATE carro SET placa = ?, renavam = ?, status = ?, categoria = ?,"
                + "tipo_motor = ?, cor = ?, modelo = ?, ano = ?, marca = ?, km_litro = ?,"
                + "volume_tanque = ?, ar_condicionado = ?, gps = ?, direcao_automatica = ?,"
                + "radio_bluetooth = ? WHERE codigo = ?";
        PreparedStatement pst;
        
        pst = Banco.getConexao().prepareStatement(sql);
        
        pst.setInt(16, t.getCodigo());
        
        pst.setString(1, t.getPlaca());
        pst.setString(2, t.getRenavam());
        pst.setInt(3, t.getStatus().getValor());
        pst.setInt(4, t.getCategoria().getValor());
        pst.setInt(5, t.getTipoMotor().getValor());
        pst.setInt(6, t.getCor().getValor());
        pst.setString(7, t.getModelo());
        pst.setInt(8, t.getAno());
        pst.setString(9, t.getMarca());
        pst.setFloat(10, t.getKmLitro());
        pst.setInt(11, t.getVolumeTanque());
        if (t.isArCondicionado()){
            pst.setInt(12, 1);
        } else {
            pst.setInt(12, 0);
        }
        
        if (t.isGps()){
            pst.setInt(13, 1);
        } else {
            pst.setInt(13, 0);
        }
        
        if (t.isDirecaoAutomatica()){
            pst.setInt(14, 1);
        } else {
            pst.setInt(14, 0);
        }
        
        if (t.isRadioBluetooth()){
            pst.setInt(15, 1);
        } else {
            pst.setInt(15, 0);
        }
        
        pst.executeUpdate();
        
        Carro alterado = this.buscar(t);
       
        return alterado;
    }
    
}
