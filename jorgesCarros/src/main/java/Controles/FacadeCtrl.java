/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

public class FacadeCtrl {
    private CtrlCarro carro;
    private CtrlGaragen garagen;
    private CtrlCliente cliente;
   
    public FacadeCtrl() {
        this.carro = new CtrlCarro();
        this.cliente = new CtrlCliente();
        this.garagen = new CtrlGaragen();
    }

    public CtrlCarro getCarro() {
        return carro;
    }
    
    public CtrlGaragen getGaragen() {
        return garagen;
    }
  
    public CtrlCliente getCliente() {
        return cliente;
    }
    
}
