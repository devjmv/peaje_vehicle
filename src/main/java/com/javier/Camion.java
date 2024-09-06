package com.javier;

class Camion extends Veiculo {

    private int numeroEjes;

    public Camion(String placa, int numeroEjes) {
        super(placa);
        if (numeroEjes < 0) {
            throw new IllegalArgumentException("El número de ejes no puede ser negativo.");
        }
        this.numeroEjes = numeroEjes;
    }

    public int getNumeroEjes() {
        return numeroEjes;
    }

    public void setNumeroEjes(int numeroEjes) {
        if (numeroEjes < 0) {
            throw new IllegalArgumentException("El número de ejes no puede ser negativo");
        }
        this.numeroEjes = numeroEjes;
    }

    @Override
    public int calcularPeaje() {
        return 50 * numeroEjes;
    }
}
