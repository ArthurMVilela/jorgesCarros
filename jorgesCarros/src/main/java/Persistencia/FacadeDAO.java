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

    public DAOCarro getCarro() {
        return carro;
    }
    public DAOEntrada getEntrada(){
        return daoe;
    }
    public DAOSaida getSaida(){
        return daos;
    }
    
}
