package org.example;

public class TarifaPorComplejidad implements PoliticaCobro {
    private double factorComplejidad;

    // Constructor corregido
    public TarifaPorComplejidad(double factorComplejidad) {
        this.factorComplejidad = factorComplejidad;
    }

    @Override
    public double calcularCosto(Atencion atencion, int hora, Paciente paciente) {
        double costo = atencion.getCostoBase();

        // Aplicar factor según el tipo de atención
        if (atencion.getTipo() == TipoAtencio.EMERGENCIA) {
            return costo * factorComplejidad;
        } else if (atencion.getTipo() == TipoAtencio.PROCEDIMIENTO) {
            return costo * (factorComplejidad * 0.8);
        } else if (atencion.getTipo() == TipoAtencio.CONSULTA) {
            return costo * (factorComplejidad * 0.6);
        } else if (atencion.getTipo() == TipoAtencio.GROOMING) {
            return costo * (factorComplejidad * 0.4);
        }

        // Caso por defecto
        return costo;
    }
}