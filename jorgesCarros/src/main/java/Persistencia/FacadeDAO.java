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
    private final DAOEntrada daoe = new DAOEntrada();
    private final DAOSaida daos = new DAOSaida();
    private final ClienteDAO client = new ClienteDAO();

    public DAOCarro getCarro() {
        return carro;
    }
  
    public DAOEntrada getEntrada(){
        return daoe;
    }
  
    public DAOSaida getSaida(){
        return daos;
    }

    public ClienteDAO getCliente() {
        // TODO Auto-generated method stub
        return client;  
    }

}
