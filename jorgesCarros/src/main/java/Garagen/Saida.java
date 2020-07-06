package Garagen;
import java.time.LocalDateTime;

import Carro.Carro;
public class Saida {
    private String motivo;
    private LocalDateTime horarioS;
    private Carro carro;
    private int  codigo;
   

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDateTime getHorarioS() {
        return horarioS;
    }

    public void setHorarioS(LocalDateTime horarioS) {
        this.horarioS = horarioS;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }


    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

  
}