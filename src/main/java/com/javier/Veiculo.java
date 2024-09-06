package com.javier;

public abstract class Veiculo {

    private String placa;

    public Veiculo(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public abstract int calcularPeaje();
}
