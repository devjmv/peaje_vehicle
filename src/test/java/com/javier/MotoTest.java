package com.javier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MotoTest {

    @Test
    void testCalcularPeaje() {
        Moto moto = new Moto("XYZ789");
        assertEquals(50, moto.calcularPeaje(), "El peaje para una moto debe ser $50");
    }
}
