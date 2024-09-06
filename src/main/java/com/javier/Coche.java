package com.javier;

class Coche extends Veiculo {

    public Coche(String placa) {
        super(placa);
    }
    @Override
    public int calcularPeaje() {
        return 100;
    }
}
