/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

public class FacadeCtrl {
    private CtrlCarro carro;
    private CtrlCliente cliente;

    
    public FacadeCtrl() {
        this.carro = new CtrlCarro();
        this.cliente = new CtrlCliente();
    }

    public CtrlCarro getCarro() {
        return carro;
    }
    
    public CtrlCliente getCliente() {
        return cliente;
    }
    
}
