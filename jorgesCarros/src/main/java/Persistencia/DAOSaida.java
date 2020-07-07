package Persistencia;

import java.sql.SQLException;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Garagen.Saida;
import java.util.ArrayList;

public class DAOSaida implements DAO<Saida> {

    @Override
    public Saida atualizar(Saida t) throws SQLException {
        final String sql = "UDPATE saida SET motivo = ? WHERE codigo = ?";
		PreparedStatement pst;
		ResultSet rs;
		
        pst = Banco.getConexao().prepareStatement(sql);
		
		pst.setString(1, t.getMotivo() );
		pst.setInt(2,t.getCodigo());

		pst.executeUpdate();
       
        rs = pst.executeQuery();
        rs.next();
        
        Saida res = new Saida();
        res = this.buscar(res);
       
        return res;
    }

    @Override
    public Saida buscar(Saida t) throws SQLException {
		final String sql="SELECT * FROM saida WHERE codigo = ?";
		PreparedStatement pst;
		ResultSet rs;
		Saida n = null;
		pst = Banco.getConexao().prepareStatement(sql);
		rs = pst.executeQuery();
		
		if (rs.next()){
		n = new Saida();
		pst.setInt(1,t.getCodigo());
		n.setCodigo(rs.getInt("codigo"));
		n.setHorarioS(rs.getTimestamp("horario").toLocalDateTime());
		}




		return n;
    }

    @Override
    public List<Saida> buscarMultiplos(String filtro) throws SQLException {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<Saida> buscarTodos() throws SQLException {
        List<Saida> SaidaL = new ArrayList<>();
		final String sql="SELECT * FROM saida";
		PreparedStatement pst;
		ResultSet rs;

		Saida n = null;
		pst = Banco.getConexao().prepareStatement(sql);
		rs = pst.executeQuery();
		
		if (rs.next()){
		n = new Saida();
		n.setCodigo(rs.getInt("codigo"));
		n.setHorarioS(rs.getTimestamp("horario").toLocalDateTime());
		}

		return SaidaL;
    }

    @Override
    public boolean excluir(Saida t) throws SQLException {
        final String sql = "DELETE FROM saida WHERE codigo = ?";
		PreparedStatement pst;
		
		
		pst = Banco.getConexao().prepareStatement(sql);
		pst.setInt(1, t.getCodigo());

		final int res = pst.executeUpdate();
    
        return res != 0;
    }

    @Override
    public Saida inserir(Saida t) throws SQLException {
        String sql = "INSERT INTO saida(motivo) VALUES (?) ";

        PreparedStatement pst;
        ResultSet rs;

        pst = Banco.getConexao().prepareStatement(sql);

        pst.setString(1, t.getMotivo());
        
        
        pst.executeUpdate();
        pst = Banco.getConexao().prepareStatement("SELECT MAX(codigo) FROM entrada");
        rs = pst.executeQuery();
        rs.next();
        
        Saida res = new Saida();
        
        res.setCodigo(rs.getInt("MAX(codigo)"));
        
        res = this.buscar(res);
       
       return res;
    }
    
}