package org.example;

public class Procedimiento extends Atencion {
    private String tipoProcedimiento;

    public Procedimiento(String tipoProcedimiento) {
        super("Procedimiento médico");
        this.tipoProcedimiento = tipoProcedimiento;
        this.tipo = TipoAtencio.PROCEDIMIENTO;
        this.costoBase = 300.0;
        this.duracionMinutos = 45;
    }

    @Override
    public String getDescripcionDetallada() {
        return "Procedimiento: " + tipoProcedimiento;
    }
}