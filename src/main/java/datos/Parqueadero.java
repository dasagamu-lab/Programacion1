package datos;

import java.util.ArrayList;
import java.util.List;

public class Parqueadero {
    private static final int CAPACIDAD = 20;
    private List<Bicicleta> bicicletas;

    public Parqueadero() {
        bicicletas = new ArrayList<>();
    }

    public boolean estaLleno() {
        return bicicletas.size() >= CAPACIDAD;
    }

    public int getCuposDisponibles() {
        return CAPACIDAD - bicicletas.size();
    }

    public List<Bicicleta> getBicicletas() {
        return bicicletas;
    }

    public void agregar(Bicicleta bicicleta) {
        bicicletas.add(bicicleta);
    }

    public Bicicleta buscarPorPropietario(String identificacion) {
        for (Bicicleta bicicleta : bicicletas) {
            if (bicicleta.getPropietario().getIdentificacion().equals(identificacion)) {
                return bicicleta;
            }
        }
        return null;
    }

    public boolean retirar(Bicicleta bicicleta) {
        return bicicletas.remove(bicicleta);
    }
}
