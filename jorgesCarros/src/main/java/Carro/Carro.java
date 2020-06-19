package Carro;

/**
 * Está classe representa os dados de um carro
 * da Jorge's Carros
 */
public class Carro {
    private int codigo; //código identificador do Carro
    private String placa, renavam;
    private StatusCarro status;
    private Categoria categoria;
    private TipoMotor tipoMotor;
    private CorCarro cor;
    private String modelo;
    private int ano;
    private String marca;
    private float kmLitro;
    private int volumeTanque;
    private boolean arCondicionado, gps, direcaoAutomatica, radioBluetooth;

    public Carro() {
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public StatusCarro getStatus() {
        return status;
    }

    public void setStatus(StatusCarro status) {
        this.status = status;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public TipoMotor getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(TipoMotor tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public CorCarro getCor() {
        return cor;
    }

    public void setCor(CorCarro cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public float getKmLitro() {
        return kmLitro;
    }

    public void setKmLitro(float kmLitro) {
        this.kmLitro = kmLitro;
    }

    public int getVolumeTanque() {
        return volumeTanque;
    }

    public void setVolumeTanque(int volumeTanque) {
        this.volumeTanque = volumeTanque;
    }

    public boolean isArCondicionado() {
        return arCondicionado;
    }

    public void setArCondicionado(boolean arCondicionado) {
        this.arCondicionado = arCondicionado;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = gps;
    }

    public boolean isDirecaoAutomatica() {
        return direcaoAutomatica;
    }

    public void setDirecaoAutomatica(boolean direcaoAutomatica) {
        this.direcaoAutomatica = direcaoAutomatica;
    }

    public boolean isRadioBluetooth() {
        return radioBluetooth;
    }

    public void setRadioBluetooth(boolean radioBluetooth) {
        this.radioBluetooth = radioBluetooth;
    }
    
    
}
