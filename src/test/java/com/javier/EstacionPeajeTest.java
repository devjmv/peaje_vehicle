package com.javier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class EstacionPeajeTest {

    private EstacionPeaje estacionPeaje;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        estacionPeaje = new EstacionPeaje("El Peaje", "Gijon");

        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testConstructor() {
        assertEquals("El Peaje", estacionPeaje.getNombre(), "El nombre de la estación debe ser 'El Peaje'");
        assertEquals("Gijon", estacionPeaje.getCiudad(), "La ciudad de la estación debe ser 'Gijon'");
    }

    @Test
    void testSettersAndGetters() {
        estacionPeaje.setNombre("Nuevo Peaje");
        assertEquals("Nuevo Peaje", estacionPeaje.getNombre(), "El nombre de la estación debe ser 'Nuevo Peaje'");

        estacionPeaje.setCiudad("Oviedo");
        assertEquals("Oviedo", estacionPeaje.getCiudad(), "La ciudad de la estación debe ser 'Oviedo'");
    }

    @Test
    void testMostrarInforme() {
        Veiculo mockVehiculo1 = mock(Veiculo.class);
        when(mockVehiculo1.getPlaca()).thenReturn("ABC123");
        when(mockVehiculo1.calcularPeaje()).thenReturn(100);

        Veiculo mockVehiculo2 = mock(Veiculo.class);
        when(mockVehiculo2.getPlaca()).thenReturn("DEF456");
        when(mockVehiculo2.calcularPeaje()).thenReturn(50);

        estacionPeaje.registrarVehiculo(mockVehiculo1);
        estacionPeaje.registrarVehiculo(mockVehiculo2);

        outContent.reset();
        estacionPeaje.mostrarInforme();

        String[] lines = outContent.toString().split("\n");
        String expected = "Estación de Peaje: El Peaje en Gijon";
        boolean found = false;
        for (String line : lines) {
            if (line.startsWith(expected)) {
                found = true;
                break;
            }
        }
        assertTrue(found, "La salida del informe debe incluir el nombre de la estación de peaje");
        String line2 = lines[2];
        assertTrue(line2.startsWith("- Placa: ABC123, Peaje: $100"), "La tercera línea debe ser '- Placa: ABC123, Peaje: $100'");
        String line3 = lines[3];
        assertTrue(line3.startsWith("- Placa: DEF456, Peaje: $50"), "La cuarta línea debe ser '- Placa: DEF456, Peaje: $50'");
        String line4 = lines[4];
        assertTrue(line4.startsWith("Total recaudado: $150"), "La quinta línea debe ser 'Total recaudado: $150'");
    }
}
