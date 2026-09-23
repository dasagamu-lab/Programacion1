package gestion;

import datos.Bicicleta;
import datos.TipoPago;

public interface OperacionesParqueadero {
    boolean ingresarBicicleta(Bicicleta bicicleta);

    double registrarSalida(String identificacionPropietario, TipoPago tipoPago, long minutos);

    String generarReporte();
}
