/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controles;

public class FacadeCtrl {
    private CtrlCarro carro;
    private CtrlGaragen garagen;
    public FacadeCtrl() {
        this.carro = new CtrlCarro();
        this.garagen = new CtrlGaragen();
    }

    public CtrlCarro getCarro() {
        return carro;
    }
    
    public CtrlGaragen getGaragen() {
        return garagen;
    }
    
}
