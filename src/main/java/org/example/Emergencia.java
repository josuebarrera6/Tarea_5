package org.example;

public class Emergencia extends Atencion {
    private String nivelUrgencia;

    public Emergencia(String nivelUrgencia) {
        super("Atención de emergencia");
        this.nivelUrgencia = nivelUrgencia;
        this.tipo = TipoAtencio.EMERGENCIA;
        this.costoBase = 500.0;
        this.duracionMinutos = 60;
    }

    public String getNivelUrgencia() {
        return nivelUrgencia;
    }

    @Override
    public String getDescripcionDetallada() {
        return "Emergencia - Urgencia: " + nivelUrgencia;
    }
}