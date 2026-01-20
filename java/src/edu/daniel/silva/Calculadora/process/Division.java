package edu.daniel.silva.Calculadora.process;

/**
 * Clase que realiza la división mediante restas sucesivas.
 */
public class Division {
    /**
     * Divide dos números enteros usando la clase Resta.
     * @param a Dividendo.
     * @param b Divisor.
     * @return El cociente entero de la división.
     * @throws ArithmeticException Si el divisor es cero.
     */
    public static int realizarOperacion(int a, int b) {
        if (b == 0) throw new ArithmeticException("División por cero");
        int cociente = 0;
        int acumulado = a;
        while (acumulado >= b) {
            acumulado = Resta.realizarOperacion(acumulado, b);
            cociente = Suma.realizarOperacion(cociente, 1);
        }
        return cociente;
    }
}