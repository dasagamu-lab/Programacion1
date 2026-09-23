package datos;

public enum TipoPago {
    EFECTIVO("Efectivo"),
    NEQUI("Nequi"),
    TRANSFERENCIA("Transferencia");

    private final String descripcion;

    TipoPago(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static void mostrarOpciones() {
        for (TipoPago tipoPago : values()) {
            System.out.println((tipoPago.ordinal() + 1) + ". " + tipoPago.getDescripcion());
        }
    }
}
