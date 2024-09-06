package com.javier;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class AppPeajeTest {

    private AppPeaje appPeaje;
    private EstacionPeaje mockEstacionPeaje;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        mockEstacionPeaje = Mockito.mock(EstacionPeaje.class);

        appPeaje = new AppPeaje();
        appPeaje.estacionPeaje = mockEstacionPeaje;

        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testAgregarCarro() {
        String input = "ABC123\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        // Ejecuta el método
        appPeaje.agregarCarro(scanner);

        ArgumentCaptor<Coche> captor = ArgumentCaptor.forClass(Coche.class);
        verify(mockEstacionPeaje, times(1)).registrarVehiculo(captor.capture());
        assertEquals("ABC123", captor.getValue().getPlaca());
    }

    @Test
    void testAgregarMoto() {
        String input = "XYZ789\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        appPeaje.agregarMoto(scanner);

        ArgumentCaptor<Moto> captor = ArgumentCaptor.forClass(Moto.class);
        verify(mockEstacionPeaje, times(1)).registrarVehiculo(captor.capture());
        assertEquals("XYZ789", captor.getValue().getPlaca());
    }

    @Test
    void testAgregarCamion() {
        String input = "LMN456\n3\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        appPeaje.agregarCamion(scanner);

        ArgumentCaptor<Camion> captor = ArgumentCaptor.forClass(Camion.class);
        verify(mockEstacionPeaje, times(1)).registrarVehiculo(captor.capture());
        assertEquals("LMN456", captor.getValue().getPlaca());
        assertEquals(3, captor.getValue().getNumeroEjes());
    }

    @Test
    void testAgregarCamionEjesNegativos() {
        String input = "LMN456\n-2\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        appPeaje.agregarCamion(scanner);

        String expectedOutput = "Error: El número de ejes no puede ser negativo.";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

    @Test
    void testMostrarInforme() {
        appPeaje.mostrarInforme();

        verify(mockEstacionPeaje, times(1)).mostrarInforme();
    }
}
