package org.example;

public interface PoliticaCobro {
    /**
     * Calcula el costo de una atención aplicando la política específica
     * @param atencion La atención a procesar
     * @param hora La hora de la cita (formato 24 horas)
     * @param paciente El paciente que recibe la atención
     * @return El costo final calculado
     */
    double calcularCosto(Atencion atencion, int hora, Paciente paciente);
}