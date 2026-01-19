package edu.daniel.silva.actividad1.ui;

import edu.daniel.silva.actividad1.data.Carro;
import edu.daniel.silva.actividad1.process.ShopManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CLI {
    public static void launchApp() {
        Scanner scanner = new Scanner(System.in);
        List<Carro> inventario = new ArrayList<>();
        inventario.add(new Carro("MAZDA 2", 15000, "Motor 1.5L, Manual"));
        inventario.add(new Carro("MAZDA 3", 20000, "Motor 2.0L, Automático"));
        inventario.add(new Carro("MAZDA CX-5", 25000, "Motor 2.5L, SUV"));
        inventario.add(new Carro("MAZDA CX-30", 22000, "Motor 1.5L, Crossover"));
        inventario.add(new Carro("MAZDA MX-5", 28000, "Motor 2.0L, Deportivo"));

        List<Carro> carrito = new ArrayList<>();
        boolean continuarPrograma = true;

        while (continuarPrograma) {
            System.out.println("\n--- BIENVENIDO A LA AGENCIA MAZDA ---");
            System.out.println("Selecciona un modelo (puedes usar el número o el nombre):");
            for (int i = 0; i < inventario.size(); i++) {
                System.out.println((i + 1) + ". " + inventario.get(i).nombre);
            }

            // --- SELECCIÓN FLEXIBLE DE MODELO ---
            Carro autoElegido = null;
            while (autoElegido == null) {
                System.out.print("\nModelo: ");
                String entrada = scanner.nextLine().trim();

                for (int i = 0; i < inventario.size(); i++) {
                    String nombre = inventario.get(i).nombre;
                    // Compara con el número (i+1), con el nombre completo, o si el nombre contiene la entrada
                    if (entrada.equals(String.valueOf(i + 1)) ||
                            nombre.equalsIgnoreCase(entrada) ||
                            (entrada.length() > 1 && nombre.toLowerCase().contains(entrada.toLowerCase()))) {

                        Carro m = inventario.get(i);
                        autoElegido = new Carro(m.nombre, m.precio, m.caracteristicas);
                        break;
                    }
                }
                if (autoElegido == null) System.out.println("Error: No se reconoce el modelo.");
            }

            autoElegido.mostrarDetalles();

            if (confirmarAccion(scanner, "¿Comprar este carro? (1. Si / 2. No)")) {
                System.out.println("\n--- PERSONALIZA TU " + autoElegido.nombre + " ---");

                // SELECCIÓN DE COLOR
                String[] colores = {"Rojo Alma", "Gris Metálico", "Blanco Perlado"};
                autoElegido.color = seleccionarFlexible(scanner, "Elige color:", colores);

                // SELECCIÓN DE ASIENTOS
                String[] asientos = {"Tela", "Piel"};
                autoElegido.asientos = seleccionarFlexible(scanner, "Elige asientos:", asientos);

                carrito.add(autoElegido);
                System.out.println("¡Configuración guardada!");

                if (!confirmarAccion(scanner, "¿Deseas comprar OTRO? (1. Si / 2. No)")) continuarPrograma = false;
            } else {
                if (!confirmarAccion(scanner, "¿Ver otro modelo? (1. Si / 2. No)")) continuarPrograma = false;
            }
        }

        if (!carrito.isEmpty()) {
            ShopManager.generarTicket(scanner, carrito);
        }
        scanner.close();
    }

    // MÉTODO PARA SELECCIONAR POR NÚMERO, NOMBRE O ABREVIACIÓN
    private static String seleccionarFlexible(Scanner sc, String mensaje, String[] opciones) {
        while (true) {
            System.out.println(mensaje);
            for (int i = 0; i < opciones.length; i++) {
                System.out.println((i + 1) + ". " + opciones[i]);
            }
            System.out.print("Tu elección: ");
            String entrada = sc.nextLine().trim().toLowerCase();

            for (int i = 0; i < opciones.length; i++) {
                String opt = opciones[i].toLowerCase();
                // Verifica número, nombre exacto o si la opción empieza con lo que escribió el usuario
                if (entrada.equals(String.valueOf(i + 1)) || opt.equals(entrada) || (entrada.length() >= 2 && opt.startsWith(entrada))) {
                    return opciones[i];
                }
            }
            System.out.println("Error: Opción no válida.");
        }
    }

    // MÉTODO PARA CONFIRMACIONES SI/NO RÁPIDAS
    private static boolean confirmarAccion(Scanner sc, String pregunta) {
        while (true) {
            System.out.print(pregunta + ": ");
            String res = sc.nextLine().trim().toLowerCase();
            if (res.equals("1") || res.startsWith("s")) return true;
            if (res.equals("2") || res.startsWith("n")) return false;
            System.out.println("Error: Responde 1/Si o 2/No.");
        }
    }
}