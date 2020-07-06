package Persistencia;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Garagen.Entrada;

public class DAOEntrada implements DAO<Entrada>
 {
    public Entrada inserir(final Entrada n) throws SQLException{
        final String sql = "INSERT INTO entrada(motivo) VALUES (?) ";

        PreparedStatement pst;
        ResultSet rs;

        pst = Banco.getConexao().prepareStatement(sql);

        pst.setString(1, n.getMotivo());
        
        pst.executeUpdate();
        pst = Banco.getConexao().prepareStatement("SELECT MAX(codigo) FROM entrada");
        rs = pst.executeQuery();
        rs.next();
        
        Entrada res = new Entrada();
        
        res.setCodigo(rs.getInt("MAX(codigo)"));
        
        res = this.buscar(res);
       
        return res;
        
        
   
    }

	@Override
	public Entrada atualizar(final Entrada t) throws SQLException {
		final String sql = "UDPATE entrada SET motivo = ?,  WHERE codigo = ?";
		PreparedStatement pst;
		ResultSet rs;
		
        pst = Banco.getConexao().prepareStatement(sql);
		
		pst.setString(1, t.getMotivo() );
		
		pst.setInt(2,t.getCodigo());

		pst.executeUpdate();
       
        rs = pst.executeQuery();
        rs.next();
        
        Entrada res = new Entrada();
        res = this.buscar(res);
       
        return res;
	}

	@Override
	public Entrada buscar(final Entrada t) throws SQLException {
		final String sql="SELECT * FROM entrada WHERE codigo = ?";
		PreparedStatement pst;
		ResultSet rs;
		Entrada n = null;
		pst = Banco.getConexao().prepareStatement(sql);
		rs = pst.executeQuery();
		
		if (rs.next()){
		n = new Entrada();
		pst.setInt(1,t.getCodigo());
		n.setCodigo(rs.getInt("codigo"));
		n.setHorarioE(rs.getTimestamp("horario").toLocalDateTime());
		}




		return n;
	}

	@Override
	public List<Entrada> buscarMultiplos(final String filtro) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Entrada> buscarTodos() throws SQLException {
		List<Entrada> entradaL = new ArrayList<>();
		final String sql="SELECT * FROM entrada";
		PreparedStatement pst;
		ResultSet rs;

		Entrada n = null;
		pst = Banco.getConexao().prepareStatement(sql);
		rs = pst.executeQuery();
		
		if (rs.next()){
		n = new Entrada();
		n.setCodigo(rs.getInt("codigo"));
		n.setHorarioE(rs.getTimestamp("horario").toLocalDateTime());
		}

		return entradaL;
	}

	@Override
	public boolean excluir(final Entrada t) throws SQLException {
		final String sql = "DELETE FROM entrada WHERE codigo = ?";
		PreparedStatement pst;
		
		
		pst = Banco.getConexao().prepareStatement(sql);
		pst.setInt(1, t.getCodigo());

		final int res = pst.executeUpdate();
    
        return res != 0;

		
	}
}