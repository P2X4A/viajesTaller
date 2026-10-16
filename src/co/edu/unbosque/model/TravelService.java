package co.edu.unbosque.model;

public class TravelService {
	
    public String determinarTipoViaje(Trip trip) {
        if (trip == null) {
            throw new IllegalArgumentException("El objeto Trip no puede ser nulo.");
        }

        double presupuesto = trip.getPresupuestoUSD();
        int duracion = trip.getDuracionDias();
        boolean temporadaAlta = trip.isEsTemporadaAlta();

        // Verificación inicial
        if (presupuesto < 500.0 || duracion < 2) {
            return "Presupuesto o duración insuficiente.";
        }

        // Viaje de Lujo (Premium)
        if (presupuesto >= 3000.0 && duracion > 10) {
            if (temporadaAlta) {
                return "Viaje de Lujo con recargo de Temporada.";
            } else {
                return "Viaje de Lujo (todo incluido).";
            }
        }

        // Viaje Intermedio (Estándar)
        if (presupuesto >= 1500.0 && duracion >= 5 && duracion <= 10) {
            return "Viaje Estándar (Destino local).";
        }

        // Viaje Básico (Económico) - cualquier otro caso que pasó la verificación inicial
        return "Viaje Económico (Mochilero).";
    }
}
