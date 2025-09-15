package org.example;

public class TarifaFija implements PoliticaCobro {

    @Override
    public double calcularCosto(Atencion atencion, int hora, Paciente paciente) {
        // Simplemente retorna el costo base sin modificaciones
        return atencion.getCostoBase();
    }
}