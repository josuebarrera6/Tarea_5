package org.example;

public class Consulta extends Atencion {
    private String especialidad;

    public Consulta(String especialidad) {
        super("Consulta médica");
        this.especialidad = especialidad;
        this.tipo = TipoAtencio.CONSULTA;
        this.costoBase = 150.0;
        this.duracionMinutos = 30;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    @Override
    public String getDescripcionDetallada() {
        return "Consulta de " + especialidad;
    }
}