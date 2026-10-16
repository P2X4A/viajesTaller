package co.edu.unbosque.view;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Consola {

    private final Scanner scanner;

    public Consola() {
        scanner = new Scanner(System.in);
    }

    public int mostrarMenu() {
        System.out.println("\n=== DETERMINADOR TIPO DE VIAJE ===");
        System.out.println("1. Determinar tipo de viaje");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
        int opcion = -1;
        try {
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer
        } catch (InputMismatchException e) {
            scanner.nextLine(); // limpiar buffer incorrecto
            opcion = -1;
        }
        return opcion;
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }

    public double pedirPresupuestoUSD() {
        while (true) {
            try {
                System.out.print("Ingrese el presupuesto en USD (ej: 1200.50): ");
                double valor = scanner.nextDouble();
                scanner.nextLine();
                if (valor < 0) {
                    System.out.println("El presupuesto no puede ser negativo. Intente nuevamente.");
                    continue;
                }
                return valor;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número válido (ej: 1200.50).");
                scanner.nextLine();
            }
        }
    }

    public int pedirDuracionDias() {
        while (true) {
            try {
                System.out.print("Ingrese la duración del viaje en días (ej: 7): ");
                int dias = scanner.nextInt();
                scanner.nextLine();
                if (dias < 0) {
                    System.out.println("La duración no puede ser negativa. Intente nuevamente.");
                    continue;
                }
                return dias;
            } catch (InputMismatchException e) {
                System.out.println("Error: debe ingresar un número entero válido.");
                scanner.nextLine();
            }
        }
    }

    public boolean pedirEsTemporadaAlta() {
        while (true) {
            System.out.print("¿Es temporada alta? (s/n): ");
            String entrada = scanner.nextLine().trim().toLowerCase();
            if (entrada.isEmpty()) {
                System.out.println("Respuesta vacía. Ingrese 's' o 'n'.");
                continue;
            }
            char c = entrada.charAt(0);
            if (c == 's') {
                return true;
            } else if (c == 'n') {
                return false;
            } else {
                System.out.println("Entrada no válida. Ingrese 's' para sí o 'n' para no.");
            }
        }
    }
}
