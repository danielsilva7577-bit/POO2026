package edu.daniel.silva.actividad1.process;

import edu.daniel.silva.actividad1.data.Carro;
import java.util.List;
import java.util.Scanner;

public class ShopManager {

    public static void generarTicket(Scanner sc, List<Carro> carrito) {
        System.out.println("\n--- DATOS DEL FINALIZACIÓN ---");
        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();

        System.out.println("\n========================================");
        System.out.println("           TICKET DE COMPRA");
        System.out.println("========================================");
        System.out.println("CLIENTE: " + nombre);
        System.out.println("----------------------------------------");

        double total = 0;
        for (Carro auto : carrito) {
            System.out.println("VEHÍCULO: " + auto.nombre);
            System.out.println(" COLOR:    " + auto.color);
            System.out.println(" ASIENTOS: " + auto.asientos);
            System.out.println(" PRECIO:   $" + auto.precio);
            System.out.println("----------------------------------------");
            total += auto.precio;
        }

        System.out.println("TOTAL FINAL: $" + total);
        System.out.println("========================================");
    }
}