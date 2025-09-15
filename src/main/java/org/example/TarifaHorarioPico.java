package org.example;

public class TarifaHorarioPico implements PoliticaCobro {
    private double porcentajeRecargo;

    public TarifaHorarioPico(double porcentajeRecargo) {
        this.porcentajeRecargo = porcentajeRecargo;
    }

    @Override
    public double calcularCosto(Atencion atencion, int hora, Paciente paciente) {
        double costo = atencion.getCostoBase();

        // Horario pico: 12pm a 3pm
        if (hora >= 12 && hora <= 15) {
            double recargo = costo * (porcentajeRecargo / 100);
            return costo + recargo;
        }

        return costo;
    }
}
