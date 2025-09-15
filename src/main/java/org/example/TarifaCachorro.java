package org.example;

public class TarifaCachorro implements PoliticaCobro {
    private double porcentajeDescuento;

    public TarifaCachorro(double porcentajeDescuento) {
        this.porcentajeDescuento = porcentajeDescuento;
    }

    @Override
    public double calcularCosto(Atencion atencion, int hora, Paciente paciente) {
        double costo = atencion.getCostoBase();

        // Si es cachorro, aplicar descuento
        if (paciente.esCachorro()) {
            double descuento = costo * (porcentajeDescuento / 100);
            return costo - descuento;
        }

        return costo;
    }
}