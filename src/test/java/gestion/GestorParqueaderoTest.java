package gestion;

import datos.Bicicleta;
import datos.Propietario;
import datos.TipoPago;

public class GestorParqueaderoTest {
    public static void main(String[] args) {
        GestorParqueadero gestor = new GestorParqueadero();
        Bicicleta bicicleta = new Bicicleta(
                new Propietario("123", "Ana"), "ABC-1", "Roja");

        assert gestor.ingresarBicicleta(bicicleta);
        assert gestor.getCuposDisponibles() == 19;
        assert gestor.registrarSalida("123", TipoPago.NEQUI, 5) == 50;
        assert gestor.getCuposDisponibles() == 20;
    }
}
