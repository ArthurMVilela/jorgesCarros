/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

/**
 *
 * @author arthur
 */
public class FacadeDAO {
    private final DAOCarro carro = new DAOCarro();
    private final ClienteDAO client = new ClienteDAO();
    private final DAOEntrada entrada = new DAOEntrada();
    private final DAOSaida saida = new DAOSaida();

    public DAOCarro getCarro() {
        return carro;
    }

    public ClienteDAO getCliente() {
            // TODO Auto-generated method stub
            return client;  
    }

    public DAOEntrada getEntrada() {
        return entrada;
    }

    public DAOSaida getSaida() {
        return saida;
    }
    
    
}
