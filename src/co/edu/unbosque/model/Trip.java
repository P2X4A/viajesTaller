package co.edu.unbosque.model;

public class Trip {

    private double presupuestoUSD;
    private int duracionDias;
    private boolean esTemporadaAlta;

    public Trip(double presupuestoUSD, int duracionDias, boolean esTemporadaAlta) {
        this.presupuestoUSD = presupuestoUSD;
        this.duracionDias = duracionDias;
        this.esTemporadaAlta = esTemporadaAlta;
    }

    public double getPresupuestoUSD() {
        return presupuestoUSD;
    }

    public void setPresupuestoUSD(double presupuestoUSD) {
        this.presupuestoUSD = presupuestoUSD;
    }

    public int getDuracionDias() {
        return duracionDias;
    }

    public void setDuracionDias(int duracionDias) {
        this.duracionDias = duracionDias;
    }

    public boolean isEsTemporadaAlta() {
        return esTemporadaAlta;
    }

    public void setEsTemporadaAlta(boolean esTemporadaAlta) {
        this.esTemporadaAlta = esTemporadaAlta;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "presupuestoUSD=" + presupuestoUSD +
                ", duracionDias=" + duracionDias +
                ", esTemporadaAlta=" + esTemporadaAlta +
                '}';
    }
}
