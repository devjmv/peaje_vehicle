package com.javier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CamionTest {

    private Camion camion;

    @BeforeEach
    void setUp() {
        camion = new Camion("LMN456", 3);
    }

    @Test
    void testConstructorValido() {
        assertEquals("LMN456", camion.getPlaca(), "La placa del camión debe ser 'LMN456'");
        assertEquals(3, camion.getNumeroEjes(), "El número de ejes debe ser 3");
    }

    @Test
    void testConstructorEjesNegativos() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            new Camion("XYZ123", -2);
        }, "Debe lanzar una IllegalArgumentException si el número de ejes es negativo");

        assertEquals("El número de ejes no puede ser negativo.", exception.getMessage(),
                     "El mensaje de la excepción debe ser 'El número de ejes no puede ser negativo.'");
    }

    @Test
    void testGetNumeroEjes() {
        assertEquals(3, camion.getNumeroEjes(), "El número de ejes debe ser 3");
    }

    @Test
    void testSetNumeroEjes() {
        camion.setNumeroEjes(4);
        assertEquals(4, camion.getNumeroEjes(), "El número de ejes debe ser 4 después de usar setNumeroEjes()");
    }

    @Test
    void testCalcularPeaje() {
        assertEquals(150, camion.calcularPeaje(), "El peaje debe ser $150 para un camión con 3 ejes");

        camion.setNumeroEjes(5);
        assertEquals(250, camion.calcularPeaje(), "El peaje debe ser $250 para un camión con 5 ejes");
    }

    @Test
    void testSetNumeroEjesInvalidValue() {
        assertThrows(IllegalArgumentException.class, () -> {
            camion.setNumeroEjes(-1);
        }, "Debe lanzar una excepción si el número de ejes es negativo");
    }
}
