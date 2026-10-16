package co.edu.unbosque.controller;

import co.edu.unbosque.model.TravelService;
import co.edu.unbosque.model.Trip;
import co.edu.unbosque.view.Consola;

public class Controlador {

    private final Consola consola;
    private final TravelService travelService;

    public Controlador() {
        this.consola = new Consola();
        this.travelService = new TravelService();
    }

    public void ejecutar() {
        boolean ejecutando = true;
        consola.mostrarMensaje("Bienvenido al determinador de tipo de viaje.");

        while (ejecutando) {
            int opcion = consola.mostrarMenu();
            switch (opcion) {
                case 1:
                    procesoDeterminarTipoViaje();
                    break;
                case 0:
                    consola.mostrarMensaje("Saliendo del programa. ¡Hasta luego!");
                    ejecutando = false;
                    break;
                default:
                    consola.mostrarMensaje("Opción no válida. Intente nuevamente.");
                    break;
            }
        }
    }

    private void procesoDeterminarTipoViaje() {
        try {
            double presupuesto = consola.pedirPresupuestoUSD();
            int dias = consola.pedirDuracionDias();
            boolean esTemporadaAlta = consola.pedirEsTemporadaAlta();

            Trip solicitud = new Trip(presupuesto, dias, esTemporadaAlta);
            String resultado = travelService.determinarTipoViaje(solicitud);

            consola.mostrarMensaje("\nResultado: " + resultado + "\n");
        } catch (Exception e) {
            // excepción inesperada -> mostrar mensaje al usuario 
            consola.mostrarMensaje("Ocurrió un error al procesar la solicitud: " + e.getMessage());
        }
    }
}
