package com.javier;

class Moto extends Veiculo {

    public Moto(String placa) {
        super(placa);
    }
    @Override
    public int calcularPeaje() {
        return 50;
    }
}
