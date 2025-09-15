package org.example;
import java.time.*;

public class Main {
    public static void main(String[] args) {
        // Crear el sistema
        SistemaClinica sistema = new SistemaClinica();

        // Mostrar saludo de IA
        sistema.saludarIA();

        System.out.println("\n=== DEMO DEL SISTEMA DE CLÍNICA VETERINARIA ===\n");

        // Crear dueños con validaciones
        Dueno dueno1 = new Dueno(1, "María González", "5555-1234");
        dueno1.actualizarEmail("maria@email.com");

        Dueno dueno2 = new Dueno();
        dueno2.setId(2);
        dueno2.setNombreCompleto("Juan Pérez");
        dueno2.actualizarTelefono("5555-5678");

        // Crear pacientes con validaciones (sobrecarga de constructores)
        Paciente firu = new Paciente(1, "Firu", "Perro", "Labrador", 8, 15.5);
        Paciente michi = new Paciente(2, "Michi");
        michi.setEspecie("Gato");
        michi.setRaza("Persa");
        michi.setEdadMeses(24);
        michi.actualizarPeso(4.2);

        Paciente rocky = new Paciente(3, "Rocky", "Perro", "Bulldog", 36, 25.0);

        // Crear diferentes tipos de atención (herencia y polimorfismo)
        Atencion consulta = new Consulta("Medicina General");
        Atencion grooming = new Grooming("Baño y corte");
        Atencion emergencia = new Emergencia("Alta");
        Atencion procedimiento = new Procedimiento("Vacunación");

        // Crear fechas válidas
        LocalDateTime fechaCita1 = LocalDateTime.of(2025, 9, 15, 10, 30);
        LocalDateTime fechaCita2 = LocalDateTime.of(2025, 9, 16, 14, 0);
        LocalDateTime fechaCita3 = LocalDateTime.of(2025, 9, 17, 11, 15);
        LocalDateTime fechaCita4 = LocalDateTime.of(2025, 9, 18, 16, 0);

        // Crear citas
        Cita cita1 = new Cita(1, firu, dueno1, fechaCita1, "Revisión general", consulta);
        Cita cita2 = new Cita(2, michi, dueno2, fechaCita2, "Aseo y corte", grooming);
        Cita cita3 = new Cita(3, firu, dueno1, fechaCita3, "Vacunas anuales", procedimiento);
        Cita cita4 = new Cita(4, rocky, dueno2, fechaCita4, "Dificultad respiratoria", emergencia);

        System.out.println("=== DEMOSTRANDO 4+ POLÍTICAS DE COBRO (Strategy Pattern) ===\n");

        // 1. Tarifa Fija
        System.out.println("--- 1. Procesando con Tarifa Fija ---");
        sistema.procesarCita(cita1);
        sistema.generarResumen(cita1);

        // 2. Tarifa para Cachorros (descuento)
        sistema.setPoliticaCobro(new TarifaCachorro(20.0));
        System.out.println("--- 2. Procesando con Descuento para Cachorros (20%) ---");
        sistema.procesarCita(cita3);
        sistema.generarResumen(cita3);

        // 3. Tarifa por Horario Pico (recargo)
        sistema.setPoliticaCobro(new TarifaHorarioPico(30.0));
        System.out.println("--- 3. Procesando con Tarifa Horario Pico (+30%) ---");
        sistema.procesarCita(cita2);
        sistema.generarResumen(cita2);

        // 4. Tarifa por Complejidad
        sistema.setPoliticaCobro(new TarifaPorComplejidad(1.5));
        System.out.println("--- 4. Procesando con Tarifa por Complejidad ---");
        sistema.procesarCita(cita4);
        sistema.generarResumen(cita4);

        System.out.println("\n=== DEMOSTRANDO STATE PATTERN - Transiciones Seguras ===\n");
        System.out.println("Estado inicial de cita1: " + cita1.getEstado());

        // Transiciones válidas
        System.out.println("¿Cambió a EN_CURSO? " + cita1.cambiarEstado(EstadoCita.EN_CURSO));
        System.out.println("Estado actual: " + cita1.getEstado());

        System.out.println("¿Cambió a FINALIZADA? " + cita1.cambiarEstado(EstadoCita.FINALIZADA));
        System.out.println("Estado actual: " + cita1.getEstado());

        // Transición inválida
        System.out.println("¿Cambió a CONFIRMADA desde FINALIZADA? " + cita1.cambiarEstado(EstadoCita.CONFIRMADA));
        System.out.println("Estado final: " + cita1.getEstado());

        System.out.println("\n=== DEMOSTRANDO TEMPLATE METHOD PATTERN ===\n");
        sistema.ejecutarAtencion(cita4); // Emergencia
        sistema.ejecutarAtencion(cita2); // Consulta normal

        System.out.println("\n=== DEMOSTRANDO VALIDACIONES ROBUSTAS ===\n");

        // Intentar cita fuera de horario
        LocalDateTime fechaInvalida = LocalDateTime.of(2025, 9, 19, 20, 0); // 8PM
        Cita citaInvalida = new Cita(5, firu, dueno1, fechaInvalida, "Consulta", consulta);
        System.out.println("--- Intentando cita fuera de horario ---");
        sistema.procesarCita(citaInvalida);

        // Demostrar composición > herencia
        System.out.println("\n=== DEMOSTRANDO COMPOSICIÓN SOBRE HERENCIA ===\n");
        System.out.println("SistemaClinica usa ReglaAgendamiento (composición)");
        System.out.println("SistemaClinica usa PoliticaCobro (composición)");
        System.out.println("Cita contiene Paciente, Dueno, Atencion (composición)");

        // Funciones específicas de paciente
        System.out.println("\n--- Información de Pacientes ---");
        System.out.println(firu.getNombre() + " es cachorro: " + firu.esCachorro());
        System.out.println(michi.getNombre() + " es cachorro: " + michi.esCachorro());
        System.out.println(rocky.getNombre() + " es cachorro: " + rocky.esCachorro());

        // Polimorfismo en tiempo de ejecución
        System.out.println("\n=== DEMOSTRANDO POLIMORFISMO ===");
        Atencion[] atenciones = {consulta, grooming, emergencia, procedimiento};

        for (Atencion atencion : atenciones) {
            System.out.println("Tipo: " + atencion.getTipo());
            System.out.println("Descripción: " + atencion.getDescripcionDetallada());
            System.out.println("Duración: " + atencion.getDuracionMinutos() + " min");
            System.out.println("Costo base: Q" + atencion.getCostoBase());
            System.out.println("---");
        }

        System.out.println("\n=== PROYECTO COMPLETADO ===");
        System.out.println("✅ Encapsulamiento: Atributos private, validaciones");
        System.out.println("✅ Abstracción: Clases abstractas e interfaces");
        System.out.println("✅ Herencia: Limitada y justificada");
        System.out.println("✅ Polimorfismo: Sobrecarga constructores y métodos abstractos");
        System.out.println("✅ Strategy Pattern: 4+ políticas de cobro");
        System.out.println("✅ State Pattern: Transiciones seguras");
        System.out.println("✅ Template Method: Flujo personalizable");
        System.out.println("✅ Validaciones robustas implementadas");
    }
}