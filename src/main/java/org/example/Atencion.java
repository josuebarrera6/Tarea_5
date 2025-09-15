package org.example;

public abstract class Atencion {
    protected String descripcion;
    protected double costoBase;
    protected int duracionMinutos;
    protected TipoAtencio tipo;

    public Atencion(String descripcion) {
        this.descripcion = descripcion;
    }

    // Getters
    public String getDescripcion() {
        return descripcion;
    }

    public double getCostoBase() {
        return costoBase;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public TipoAtencio getTipo() {
        return tipo;
    }

    // Método abstracto que deben implementar las subclases
    public abstract String getDescripcionDetallada();
}

