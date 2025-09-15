package org.example;

public class Grooming extends Atencion {
    private String tipoServicio;

    public Grooming(String tipoServicio) {
        super("Servicio de grooming");
        this.tipoServicio = tipoServicio;
        this.tipo = TipoAtencio.GROOMING;
        this.costoBase = 100.0;
        this.duracionMinutos = 90;
    }

    @Override
    public String getDescripcionDetallada() {
        return "Grooming: " + tipoServicio;
    }
}