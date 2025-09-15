// ========== Dueno.java ==========
package org.example;

public class Dueno {
    private long id;
    private String nombreCompleto;
    private String telefono;
    private String email;

    // Constructor vacío
    public Dueno() {
    }

    // Constructor con parámetros básicos
    public Dueno(long id, String nombreCompleto, String telefono) {
        setId(id);
        setNombreCompleto(nombreCompleto);
        setTelefono(telefono);
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

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        if (nombreCompleto != null && !nombreCompleto.trim().isEmpty()) {
            this.nombreCompleto = nombreCompleto;
        }
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono != null && !telefono.trim().isEmpty()) {
            this.telefono = telefono;
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        }
    }

    // Métodos adicionales
    public void actualizarTelefono(String telefono) {
        setTelefono(telefono);
    }

    public void actualizarEmail(String email) {
        setEmail(email);
    }
}