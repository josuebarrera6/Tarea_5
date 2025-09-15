// Ejecutar atención - Template Method Pattern
public void ejecutarAtencion(Cita cita) {
    System.out.println("=== EJECUTANDO ATENCIÓN ===");
    System.out.println("Paciente: " + cita.getPaciente().getNombre());
    System.out.println("Tipo: " + cita.getAtencion().getTipo());

    // Cambiar estado a EN_CURSO
    if (cita.cambiarEstado(EstadoCita.EN_CURSO)) {
        System.out.println("Estado cambiado a: EN_CURSO");
    }

    // Ejecutar pasos específicos según el tipo
    switch (cita.getAtencion().getTipo()) {
        case EMERGENCIA:
            System.out.println("🚨 PROTOCOLO DE EMERGENCIA:");
            System.out.println("1. Evaluación inmediata");
            System.out.println("2. Estabilización del paciente");
            System.out.println("3. Tratamiento urgente");
            break;

        case CONSULTA:
            System.out.println("👩‍⚕️ PROTOCOLO DE CONSULTA:");
            System.out.println("1. Examen físico general");
            System.out.println("2. Diagnóstico");
            System.out.println("3. Recomendaciones");
            break;

        case PROCEDIMIENTO:
            System.out.println("🔬 PROTOCOLO DE PROCEDIMIENTO:");
            System.out.println("1. Preparación del equipo");
            System.out.println("2. Administración/Aplicación");
            System.out.println("3. Observación post-procedimiento");
            break;

        case GROOMING:
            System.out.println("✂️ PROTOCOLO DE GROOMING:");
            System.out.println("1. Evaluación del pelaje");
            System.out.println("2. Baño y secado");
            System.out.println("3. Corte y acabado");
            break;
    }

    // Finalizar atención
    if (cita.cambiarEstado(EstadoCita.FINALIZADA)) {
        System.out.println("✅ Atención finalizada correctamente");
        System.out.println("Estado cambiado a: FINALIZADA");
    }

    System.out.println("============================\n");
}
