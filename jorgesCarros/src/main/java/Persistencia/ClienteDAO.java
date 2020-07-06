package Persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import Cliente.Cliente;
import Cliente.Endereco;

public class ClienteDAO implements DAO<Cliente> {

	public Cliente buscar(String cpf) throws SQLException {
		String sql = "SELECT * FROM cliente WHERE cpf = ?";
		PreparedStatement pst;
		ResultSet rs;

		Cliente cliente = new Cliente();

		pst = Banco.getConexao().prepareStatement(sql);

		pst.setString(1, cpf);

		rs = pst.executeQuery();

		if (rs.next()) {

			cliente.setCpf(rs.getString("cpf"));
			cliente.setNome(rs.getString("nome"));
			cliente.setCnh(rs.getString("cnh"));
			cliente.setDataNascimento(rs.getDate("datanasc"));
			cliente.setRg(rs.getString("rg"));
			// fazer a inserção no endereco
			Endereco endereco = buscarEndereco(rs.getInt("codendereco"));
			cliente.setEndereco(endereco);
		}

		return cliente;

	}

	public Endereco buscarEndereco(int codEndereco) throws SQLException {

		String sql = "SELECT * FROM endereco WHERE codendereco = ?";
		PreparedStatement pst;
		ResultSet rs;

		Endereco endereco = null;

		pst = Banco.getConexao().prepareStatement(sql);

		pst.setInt(1, codEndereco);

		rs = pst.executeQuery();

		if (rs.next()) {
			endereco = new Endereco();

			endereco.setCodEndereco(rs.getInt("codendereco"));
			endereco.setLogradouro(rs.getString("logradouro"));
			endereco.setNumero(rs.getInt("numero"));
			endereco.setComplemento(rs.getString("complemento"));
			endereco.setBairro(rs.getString("bairro"));
			endereco.setCep(rs.getString("cep"));
			endereco.setCidade(rs.getString("cidade"));
			endereco.setEstado(rs.getString("estado"));
		}

		return endereco;
	}

	public List<Cliente> buscarMultiplos(List<String> listCpf) throws SQLException {

		List<Cliente> listCliente = new LinkedList<Cliente>();

		for (String cpf : listCpf) {
			Cliente cliente = buscar(cpf);
			listCliente.add(cliente);
		}

		return listCliente;
	}

	@Override
	public List<Cliente> buscarTodos() throws SQLException {

		String sql = "SELECT * FROM cliente";
		PreparedStatement pst;
		ResultSet rs;

		List<Cliente> listCliente = new LinkedList<Cliente>();

		pst = Banco.getConexao().prepareStatement(sql);

		rs = pst.executeQuery();

		while (rs.next()) {
			Cliente cliente = new Cliente(null);

			cliente.setCpf(rs.getString("cpf"));
			cliente.setNome(rs.getString("nome"));
			cliente.setCnh(rs.getString("cnh"));
			cliente.setDataNascimento(rs.getDate("datanasc"));
			cliente.setRg(rs.getString("rg"));
			// fazer a inserção no endereco
			Endereco endereco = buscarEndereco(rs.getInt("codendereco"));
			cliente.setEndereco(endereco);

			listCliente.add(cliente);
		}

		return listCliente;

	}

	@Override
	public Cliente inserir(Cliente cliente) throws SQLException {

		inserirEndereco(cliente.getEndereco());

		String sql = "INSERT INTO cliente" + " (cpf, nome, rg, cnh, datanasc, codendereco)" + " VALUES (?,?,?,?,?,?)";

		PreparedStatement pst;

		pst = Banco.getConexao().prepareStatement(sql);

		pst.setString(1, cliente.getCpf());
		pst.setString(2, cliente.getNome());
		pst.setString(3, cliente.getRg());
		pst.setString(4, cliente.getCnh());
		pst.setDate(5, cliente.getDataNascimento());
		pst.setInt(6, cliente.getEndereco().getCodEndereco()); // codigo de identificacao do endereco

		pst.execute();

		return cliente;
	}

	public void inserirEndereco(Endereco endereco) throws SQLException {

		String sql = "INSERT INTO endereco "
				+ " (codendereco, cep, cidade, estado, bairro, numero, complemento, logradouro)"
				+ " VALUES (?,?,?,?,?,?,?,?)";

		PreparedStatement pst;

		pst = Banco.getConexao().prepareStatement(sql);

		pst.setInt(1, endereco.getCodEndereco());
		pst.setString(2, endereco.getCep());
		pst.setString(3, endereco.getCidade());
		pst.setString(4, endereco.getEstado());
		pst.setString(5, endereco.getBairro());
		pst.setInt(6, endereco.getNumero());
		pst.setString(7, endereco.getComplemento());
		pst.setString(8, endereco.getLogradouro());

		pst.execute();

	}

	@Override
	public boolean excluir(Cliente cliente) throws SQLException {

		String sql = "DELETE FROM cliente WHERE cpf = ?";
		
		PreparedStatement pst = Banco.getConexao().prepareStatement(sql);;
		
		pst.setString(1, cliente.getCpf());
		
		pst.execute();

		return true;
	}
	

	@Override
	public Cliente atualizar(Cliente cliente) throws SQLException {
		String sql = "UPDATE cliente SET nome = ?, rg = ?, cnh = ?, datanasc = ?, codendereco = ? where cpf = ?";

		PreparedStatement pst;

		pst = Banco.getConexao().prepareStatement(sql);

		pst.setString(6, cliente.getCpf());

		pst.setString(1, cliente.getNome());
		pst.setString(2, cliente.getRg());
		pst.setString(3, cliente.getCnh());
		pst.setDate(4, cliente.getDataNascimento());
		pst.setInt(5, cliente.getEndereco().getCodEndereco());

		pst.execute();

		Cliente clientealterado = this.buscar(cliente.getCpf());

		return clientealterado;

	}

	public void atualizarEndereco(Endereco endereco) throws SQLException {
		String sql = "UPDATE endereco SET cep = ?, cidade = ?, estado = ?, bairro = ?, numero = ?, "
				+ " complemento = ?, logradouro = ? where codendereco = ?";

		PreparedStatement pst;

		pst = Banco.getConexao().prepareStatement(sql);

		pst.setString(1, endereco.getCep());
		pst.setString(2, endereco.getCidade());
		pst.setString(3, endereco.getEstado());
		pst.setString(4, endereco.getBairro());
		pst.setInt(5, endereco.getNumero());
		pst.setString(6, endereco.getComplemento());
		pst.setString(7, endereco.getLogradouro());
		pst.setInt(8, endereco.getCodEndereco());

		pst.execute();

	}

	@Override
	public Cliente buscar(Cliente t) throws SQLException {
		// TODO Auto-generated method stub
		// fiz a busca pelo cpf
		// esta declarado no codigo acima.
		return null;
	}

	@Override
	public List<Cliente> buscarMultiplos(String filtro) throws SQLException {
		// TODO Auto-generated method stub
		// nao vou implementar nada aqui pq ja esta feito de forma diferente
		// se eu nao adicionasse ia dar erro, entao deixei aqui
		return null;
	}

}