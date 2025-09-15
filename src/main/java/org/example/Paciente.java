package org.example;

public class Paciente {
    private long id;
    private String nombre;
    private String especie;
    private String raza;
    private int edadMeses;
    private double pesoKg;

    // Constructor vacío
    public Paciente() {
    }

    // Constructor con solo id y nombre
    public Paciente(long id, String nombre) {
        setId(id);
        setNombre(nombre);
    }

    // Constructor completo (sobrecarga)
    public Paciente(long id, String nombre, String especie, String raza, int edadMeses, double pesoKg) {
        setId(id);
        setNombre(nombre);
        setEspecie(especie);
        setRaza(raza);
        setEdadMeses(edadMeses);
        setPesoKg(pesoKg);
    }

    // Getters y Setters con validaciones
    public long getId() {
        return id;
    }

    public void setId(long id) {
        if (id > 0) {
            this.id = id;
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        }
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        if (especie != null && !especie.trim().isEmpty()) {
            this.especie = especie;
        }
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        if (raza != null && !raza.trim().isEmpty()) {
            this.raza = raza;
        }
    }

    public int getEdadMeses() {
        return edadMeses;
    }

    public void setEdadMeses(int edadMeses) {
        if (edadMeses >= 0) {
            this.edadMeses = edadMeses;
        }
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        if (pesoKg > 0) {
            this.pesoKg = pesoKg;
        }
    }

    // Métodos adicionales
    public boolean esCachorro() {
        return edadMeses <= 12;
    }

    public void cumplirMes() {
        this.edadMeses++;
    }

    public void actualizarPeso(double peso) {
        setPesoKg(peso);
    }
}