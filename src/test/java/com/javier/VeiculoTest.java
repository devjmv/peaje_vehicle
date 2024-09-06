package com.javier;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class VeiculoTest {

    @Test
    void testGetPlaca() {
        // Usamos Coche para probar el comportamiento de Vehiculo
        Veiculo vehiculo = new Coche("ABC123");
        assertEquals("ABC123", vehiculo.getPlaca(), "La placa del vehículo debe ser ABC123");
    }
}
