package Garagen;

import java.time.LocalDateTime;


public class Entrada {
    private String motivo;
    private LocalDateTime  horarioE;
   
    private int  codigo;
    

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public LocalDateTime getHorarioE() {
        return horarioE;
    }

    public void setHorarioE(LocalDateTime horarioE) {
        this.horarioE = horarioE;
    }

    }
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }


}