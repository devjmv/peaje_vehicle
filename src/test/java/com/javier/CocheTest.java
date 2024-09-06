package com.javier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CocheTest {

    @Test
    void testCalcularPeaje() {
        Coche coche = new Coche("ABC123");
        assertEquals(100, coche.calcularPeaje(), "El peaje para un coche debe ser $100");
    }
}
