package datos;

public class Propietario {
    private String identificacion;
    private String nombre;

    public Propietario(String identificacion, String nombre) {
        this.identificacion = identificacion;
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public String getNombre() {
        return nombre;
    }
}
