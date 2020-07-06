package jorgesCarros_arthur;

import org.junit.Test;

import Cliente.Cliente;
import Cliente.Endereco;
import Controles.CtrlCliente;

public class CtrlClienteTest {

	@Test
	public void criarJson() {
		
		CtrlCliente ctrlCliente = new CtrlCliente();
		Endereco endereco = new Endereco();
		Cliente cliente = new Cliente(endereco);
		
		cliente.setNome("nome1");
		
		String json = ctrlCliente.transformarJSON(cliente);
		
		System.out.println(json);
	}
	
	@Test
	public void criarCliente() {
		
		CtrlCliente ctrlCliente = new CtrlCliente();
		
		Cliente cliente = ctrlCliente.lerJSON("{\"nome\":\"nome1\"}");
		
		System.out.println(cliente.getNome());
	}
}
