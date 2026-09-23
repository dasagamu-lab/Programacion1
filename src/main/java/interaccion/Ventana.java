package interaccion;

import datos.Bicicleta;
import datos.Propietario;
import datos.TipoPago;
import gestion.GestorParqueadero;

import java.util.Scanner;

public class Ventana {
    private GestorParqueadero gestor;
    private Scanner scanner;

    public Ventana() {
        gestor = new GestorParqueadero();
        scanner = new Scanner(System.in);
    }

    public void iniciar() {
        int opcion;
        do {
            mostrarMenu();
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1:
                    ingresarBicicleta();
                    break;
                case 2:
                    registrarSalida();
                    break;
                case 3:
                    System.out.println(gestor.generarReporte());
                    break;
                case 0:
                    System.out.println("Programa finalizado.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private void mostrarMenu() {
        System.out.println();
        System.out.println("========================================");
        System.out.println("       PARQUEADERO BICI-RÁPIDO");
        System.out.println("========================================");
        System.out.println(" Cupos disponibles: " + gestor.getCuposDisponibles());
        System.out.println("----------------------------------------");
        System.out.println(" [1] Registrar ingreso de bicicleta");
        System.out.println(" [2] Registrar salida y realizar pago");
        System.out.println(" [3] Consultar reporte del día");
        System.out.println(" [0] Cerrar programa");
        System.out.println("----------------------------------------");
        System.out.print(" Escriba una opción: ");
    }

    private void ingresarBicicleta() {
        System.out.print("Identificación del propietario: ");
        String identificacion = scanner.nextLine();
        System.out.print("Nombre del propietario: ");
        String nombre = scanner.nextLine();
        System.out.print("Serial de la bicicleta: ");
        String serial = scanner.nextLine();
        System.out.print("Color de la bicicleta: ");
        String color = scanner.nextLine();

        Bicicleta bicicleta = new Bicicleta(new Propietario(identificacion, nombre), serial, color);
        if (gestor.ingresarBicicleta(bicicleta)) {
            System.out.println("Bicicleta ingresada. Cupos disponibles: " + gestor.getCuposDisponibles());
        } else {
            System.out.println("No se pudo ingresar: el parqueadero está lleno o el propietario ya tiene bicicleta.");
        }
    }

    private void registrarSalida() {
        System.out.print("Identificación del propietario: ");
        String identificacion = scanner.nextLine();
        System.out.print("Minutos de permanencia: ");
        long minutos = Long.parseLong(scanner.nextLine());
        TipoPago.mostrarOpciones();
        System.out.print("Método de pago: ");
        int opcionPago = Integer.parseInt(scanner.nextLine());

        TipoPago tipoPago;
        if (opcionPago == 1) {
            tipoPago = TipoPago.EFECTIVO;
        } else if (opcionPago == 2) {
            tipoPago = TipoPago.NEQUI;
        } else {
            tipoPago = TipoPago.TRANSFERENCIA;
        }

        double valor = gestor.registrarSalida(identificacion, tipoPago, minutos);
        if (valor < 0) {
            System.out.println("No se encontró una bicicleta con esa identificación.");
        } else {
            System.out.println("Salida registrada. Total a pagar: $" + valor);
        }
    }
}
