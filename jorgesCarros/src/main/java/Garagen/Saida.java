package Garagen;
import java.sql.Date;

import Carro.Carro;
public class Saida {
    private String motivo;
    private Date horarioS;
    private Carro carro;
    private int hora;

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Date getHorarioS() {
        return horarioS;
    }

    public void setHorarioS(Date horarioS) {
        this.horarioS = horarioS;
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