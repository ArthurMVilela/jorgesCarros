package Garagen;
import java.sql.Date;

import Carro.Carro;
public class Entrada {
    private String motivo;
    private Date horarioE;
    private Carro carro;
    private int hora;

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getHorarioE() {
        return horarioE;
    }

    public void setHorarioE(Date horarioE) {
        this.horarioE = horarioE;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }
}