package edu.daniel.silva.Calculadora.process;

/**
 * Clase que obtiene el residuo de una división mediante restas.
 */
public class Modulo {
    /**
     * Calcula el residuo usando la clase Resta.
     * @param a Dividendo.
     * @param b Divisor.
     * @return El residuo (módulo) resultante.
     */
    public static int realizarOperacion(int a, int b) {
        int acumulado = a;
        while (acumulado >= b) {
            acumulado = Resta.realizarOperacion(acumulado, b);
        }
        return acumulado;
    }
}