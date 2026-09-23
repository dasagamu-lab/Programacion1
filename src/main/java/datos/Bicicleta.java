package datos;

import java.time.LocalDateTime;

public class Bicicleta {
    private Propietario propietario;
    private String serial;
    private String color;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSalida;
    private TipoPago tipoPago;
    private double valorPagado;

    public Bicicleta(Propietario propietario, String serial, String color) {
        this.propietario = propietario;
        this.serial = serial;
        this.color = color;
        this.horaEntrada = LocalDateTime.now();
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public String getSerial() {
        return serial;
    }

    public String getColor() {
        return color;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public TipoPago getTipoPago() {
        return tipoPago;
    }

    public double getValorPagado() {
        return valorPagado;
    }

    public void registrarSalida(long minutos, TipoPago tipoPago) {
        this.horaSalida = LocalDateTime.now();
        this.tipoPago = tipoPago;
        this.valorPagado = minutos * 10;
    }
}
