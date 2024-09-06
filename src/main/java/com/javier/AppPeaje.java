package com.javier;

import java.util.Scanner;

public class AppPeaje {

    EstacionPeaje estacionPeaje = new EstacionPeaje("El Peaje", "Gijon");

    public void appRun() {
        System.out.println(
                "Bienvenido a la estación de peaje de la estación " + estacionPeaje.getNombre() + " de "
                        + estacionPeaje.getCiudad() + ".");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("1. Agregar un Carro");
            System.out.println("2. Agregar una Moto");
            System.out.println("3. Agregar un Camion");
            System.out.println("4. Mostrar Informe");
            System.out.println("5. Exit");
            System.out.print("Escoje una Opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    agregarCarro(scanner);
                    break;
                case 2:
                    agregarMoto(scanner);
                    break;
                case 3:
                    agregarCamion(scanner);
                    break;
                case 4:
                    mostrarInforme();
                    break;
                case 5:
                    System.out.println("Salir de la aplicación.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción Invalida. Intenta de nuevo.");
            }
        }
    }

    public void agregarCarro(Scanner scanner) {
        System.out.print("Ingresa la placa del carro: ");
        String placa = scanner.nextLine();
        estacionPeaje.registrarVehiculo(new Coche(placa));
    }

    public void agregarMoto(Scanner scanner) {
        System.out.print("Ingresa la placa de la moto: ");
        String placa = scanner.nextLine();
        estacionPeaje.registrarVehiculo(new Moto(placa));
    }

    public void agregarCamion(Scanner scanner) {
        System.out.print("Ingresa la placa del camion: ");
        String placa = scanner.nextLine();
        System.out.print("Ingresa la cantidad de ejes del camion: ");
        int ejes = Integer.parseInt(scanner.nextLine());
        estacionPeaje.registrarVehiculo(new Camion(placa, ejes));
    }

    public void mostrarInforme() {
        estacionPeaje.mostrarInforme();
    }
}
