package Controles;

import Garagen.Entrada;
import Garagen.Saida;
import java.util.List;
import Persistencia.FacadeDAO;



public class CtrlGaragen {
   private FacadeDAO dao = new FacadeDAO();


    public Entrada registrarE(Entrada entrada){
           Entrada e;
           try {
               e = dao.getEntrada().inserir(entrada);
           } catch (Exception ex) {
               e = null;
           }
           return e;
    }

    public Saida registrarS(Saida saida){
        Saida s;
       
        try {
            s = dao.getSaida().inserir(saida);
        } catch (Exception e) {
            s = null;
        }
        return s;

    }

    public Entrada buscarE(int codigo){
        Entrada e = new Entrada();
        e.setCodigo(codigo);

        try {
            e = dao.getEntrada().buscar(e);
        } catch (Exception ex) {
            e = null;
        }
        return e;

    }
    public Saida buscarS(int codigo){
        Saida s = new Saida();
        s.setCodigo(codigo);
        try {
            s = dao.getSaida().buscar(s);
        } catch (Exception e) {
            s = null;
        }
        return s;
    }

    public List<Entrada> buscarME(){
        List<Entrada> e;
    try {
        e = dao.getEntrada().buscarTodos();
    } catch (Exception ex) {
        e = null;
    }
    return e;
    }

    public List<Saida> buscarSE(){
        List<Saida> s;
    try {
        s = dao.getSaida().buscarTodos();
    } catch (Exception ex) {
        s = null;
    }
    return s;
    }
}