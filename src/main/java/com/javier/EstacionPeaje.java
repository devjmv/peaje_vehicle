package com.javier;

import java.util.ArrayList;
import java.util.List;

class EstacionPeaje {

    private String nombre;
    private String ciudad;
    private int totalRecaudado;
    private List<Veiculo> veiculos;

    public EstacionPeaje(String nombre, String ciudad) {
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.totalRecaudado = 0;
        this.veiculos = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public void registrarVehiculo(Veiculo vehiculo) {
        int peaje = vehiculo.calcularPeaje();
        totalRecaudado += peaje;
        veiculos.add(vehiculo);
        System.out.println("Vehículo con placa " + vehiculo.getPlaca() + " registrado, peaje: $" + peaje);
    }

    public void mostrarInforme() {
        System.out.println("Estación de Peaje: " + nombre + " en " + ciudad);
        System.out.println("Vehículos registrados:");
        for (Veiculo vehiculo : veiculos) {
            System.out.println("- Placa: " + vehiculo.getPlaca() + ", Peaje: $" + vehiculo.calcularPeaje());
        }
        System.out.println("Total recaudado: $" + totalRecaudado);
    }
}
