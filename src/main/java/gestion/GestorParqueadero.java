package gestion;

import datos.Bicicleta;
import datos.Parqueadero;
import datos.TipoPago;

public class GestorParqueadero implements OperacionesParqueadero {
    private Parqueadero parqueadero;
    private double totalRecaudado;
    private int totalBicicletasIngresadas;

    public GestorParqueadero() {
        parqueadero = new Parqueadero();
    }

    @Override
    public boolean ingresarBicicleta(Bicicleta bicicleta) {
        if (parqueadero.estaLleno() || parqueadero.buscarPorPropietario(
                bicicleta.getPropietario().getIdentificacion()) != null) {
            return false;
        }
        parqueadero.agregar(bicicleta);
        totalBicicletasIngresadas++;
        return true;
    }

    @Override
    public double registrarSalida(String identificacionPropietario, TipoPago tipoPago, long minutos) {
        Bicicleta bicicleta = parqueadero.buscarPorPropietario(identificacionPropietario);
        if (bicicleta == null || minutos < 0) {
            return -1;
        }
        bicicleta.registrarSalida(minutos, tipoPago);
        parqueadero.retirar(bicicleta);
        totalRecaudado += bicicleta.getValorPagado();
        return bicicleta.getValorPagado();
    }

    public int getCuposDisponibles() {
        return parqueadero.getCuposDisponibles();
    }

    @Override
    public String generarReporte() {
        return "Bicicletas ingresadas: " + totalBicicletasIngresadas
                + "\nValor ingresado: $" + totalRecaudado
                + "\nCupos disponibles: " + getCuposDisponibles();
    }
}
