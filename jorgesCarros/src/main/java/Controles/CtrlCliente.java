package Controles;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import Cliente.Cliente;
import Persistencia.FacadeDAO;

public class CtrlCliente {

	private FacadeDAO dao = new FacadeDAO();

	/**
	 * Adiciona o carro ao banco de dados e retorna o veículo já cadastrado no
	 * sistema.
	 * 
	 * @param cliente cliente a ser cadastrado
	 * @return cliente cadastrado
	 */

	// adicionar Cliente
	public Cliente adicionarCliente(Cliente cliente) {

		Cliente client;

		try {
			client = dao.getCliente().inserir(cliente);
		} catch (SQLException ex) {
			System.out.println(ex);
			client = null;
		}

		return client;
	}

	// alterar Cliente
	public Cliente alterarCliente(Cliente cliente) {
		 
		Cliente clienteRetorno = new Cliente();  
				 
        try {
            clienteRetorno = dao.getCliente().atualizar(cliente);
        } catch (SQLException ex) {
            clienteRetorno = null;
        }
        
        return clienteRetorno;
    }
	/**
	 * Busca um clinte no banco de dados.
	 * 
	 * @param cpf cpf do cliente
	 * @return cliente cadastrado no sistema
	 */
	// buscar Cliente
	public Cliente buscarCliente(String cpf) {
		Cliente cliente = new Cliente();

		try {
			cliente = dao.getCliente().buscar(cpf);
		} catch (SQLException ex) {
			System.out.println(ex);
			cliente = null;
		}

		return cliente;
	}
	
	/**
	 * BUSCAR TODOS
	 * @return
	 */
	public List<Cliente> buscarTodos() {
        List<Cliente> cliente;

        try {
            cliente = dao.getCliente().buscarTodos();
        } catch (SQLException ex) {
        	System.out.println(ex);
            cliente = null;
        }
                
        return cliente;
    }
	

	// excluir Cliente
	public boolean excluirCliente(String cpf) {
		Cliente cliente = new Cliente();
		boolean res;

		cliente.setCpf(cpf);

		try {
			res = dao.getCliente().excluir(cliente);
		} catch (SQLException ex) {
			System.out.println(ex);
			res = false;
		}

		return res;
	}

	public Cliente lerJSON(String json) {
		ObjectMapper mapper = new ObjectMapper();
		Cliente cliente = null;
		
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
		
		try {
			cliente = mapper.readValue(json, Cliente.class);
		} catch (IOException ex) {
			System.out.println(ex);
		}

		return cliente;
	}

	public String transformarJSON(Cliente cliente) {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
	
		try {
			json = mapper.writeValueAsString(cliente);
		} catch (Exception ex) {
			System.out.println(ex);
			json = "";
		}

		return json;
	}

	public String transformarJSON(List<Cliente> cliente) {
		ObjectMapper mapper = new ObjectMapper();
		String json;
		
		mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

		try {
			json = mapper.writeValueAsString(cliente);
		} catch (Exception ex) {
			json = "";
		}

		return json;
	}

}
