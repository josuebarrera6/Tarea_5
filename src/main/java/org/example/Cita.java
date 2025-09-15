package org.example;

import java.time.LocalDateTime;

public class Cita {
    private long id;
    private Paciente paciente;
    private Dueno dueno;
    private LocalDateTime fecha;
    private String motivo;
    private Atencion atencion;
    private EstadoCita estado;
    private double costoCalculado;

    // Constructor
    public Cita(long id, Paciente paciente, Dueno dueno, LocalDateTime fecha, String motivo, Atencion atencion) {
        this.id = id;
        this.paciente = paciente;
        this.dueno = dueno;
        this.fecha = fecha;
        this.motivo = motivo;
        this.atencion = atencion;
        this.estado = EstadoCita.PROGRAMADA; // Estado inicial
        this.costoCalculado = 0.0;
    }

    // Getters
    public long getId() {
        return id;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public String getMotivo() {
        return motivo;
    }

    public Atencion getAtencion() {
        return atencion;
    }

    public EstadoCita getEstado() {
        return estado;
    }

    public double getCostoCalculado() {
        return costoCalculado;
    }

    // Setters
    public void setCostoCalculado(double costoCalculado) {
        this.costoCalculado = costoCalculado;
    }

    // State Pattern - Transiciones válidas entre estados
    public boolean cambiarEstado(EstadoCita nuevoEstado) {
        if (esTransicionValida(this.estado, nuevoEstado)) {
            this.estado = nuevoEstado;
            return true;
        }
        System.out.println("❌ Transición inválida: " + this.estado + " → " + nuevoEstado);
        return false;
    }

    // Validar transiciones entre estados
    private boolean esTransicionValida(EstadoCita estadoActual, EstadoCita estadoDestino) {
        switch (estadoActual) {
            case PROGRAMADA:
                return estadoDestino == EstadoCita.CONFIRMADA ||
                        estadoDestino == EstadoCita.CANCELADA;

            case CONFIRMADA:
                return estadoDestino == EstadoCita.EN_CURSO ||
                        estadoDestino == EstadoCita.CANCELADA;

            case EN_CURSO:
                return estadoDestino == EstadoCita.FINALIZADA;

            case FINALIZADA:
            case CANCELADA:
                return false; // Estados finales

            default:
                return false;
        }
    }

    // Método para reprogramar cita
    public void reprogramar(LocalDateTime nuevaFecha) {
        if (this.estado == EstadoCita.PROGRAMADA || this.estado == EstadoCita.CONFIRMADA) {
            this.fecha = nuevaFecha;
            this.estado = EstadoCita.PROGRAMADA; // Resetear a programada
            System.out.println("✅ Cita reprogramada para: " + nuevaFecha);
        } else {
            System.out.println("❌ No se puede reprogramar una cita en estado: " + this.estado);
        }
    }
}
