package edu.daniel.silva.Calculadora.ui;

import edu.daniel.silva.Calculadora.process.*;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Interfaz de Línea de Comandos (CLI) que gestiona la interacción con el usuario.
 * Se encarga de mostrar el menú, capturar datos y validar que no se ingresen letras.
 */
public class CLI {
    /**
     * Despliega el menú principal y gestiona el flujo de la calculadora.
     * Utiliza un bloque try-catch para capturar errores de entrada no numérica.
     */
    public static void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        int opcion = -1;

        while (opcion != 0) {
            System.out.println("\n--- CALCULADORA ARITMÉTICA (POO) ---");
            System.out.println("Elige una ocpion del menu");
            System.out.println("1. Suma          2. Resta        3. Multiplicación");
            System.out.println("4. División      5. Módulo       6. Potencia");
            System.out.println("7. Raíz          8. Logaritmo    0. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                opcion = scanner.nextInt();

                if (opcion == 0) {
                    System.out.println("Programa finalizado.");
                    break;
                }

                if (opcion < 1 || opcion > 8) {
                    System.out.println("Opción no válida.");
                    continue;
                }

                System.out.print("Ingrese el primer operando: ");
                int n1 = scanner.nextInt();
                System.out.print("Ingrese el segundo operando: ");
                int n2 = scanner.nextInt();

                ejecutarOperacion(opcion, n1, n2);

            } catch (InputMismatchException e) {
                System.out.println("Error: ¡Solo se permiten números enteros!");
                scanner.nextLine(); // Limpiar el buffer
                opcion = -1;
            } catch (ArithmeticException e) {
                System.out.println("Error matemático: " + e.getMessage());
            }
        }
    }

    /**
     * Método auxiliar para dirigir la ejecución según la opción seleccionada.
     * @param opcion El número de operación elegido.
     * @param n1 Primer número.
     * @param n2 Segundo número.
     */
    private static void ejecutarOperacion(int opcion, int n1, int n2) {
        switch (opcion) {
            case 1 -> System.out.println("Resultado: " + Suma.realizarOperacion(n1, n2));
            case 2 -> System.out.println("Resultado: " + Resta.realizarOperacion(n1, n2));
            case 3 -> System.out.println("Resultado: " + Multiplicacion.realizarOperacion(n1, n2));
            case 4 -> System.out.println("Resultado: " + Division.realizarOperacion(n1, n2));
            case 5 -> System.out.println("Resultado: " + Modulo.realizarOperacion(n1, n2));
            case 6 -> System.out.println("Resultado: " + Potencia.realizarOperacion(n1, n2));
            case 7 -> System.out.println("Resultado: " + Raiz.realizarOperacion(n1, n2));
            case 8 -> System.out.println("Resultado: " + Logaritmo.realizarOperacion(n1, n2));
        }
    }
}