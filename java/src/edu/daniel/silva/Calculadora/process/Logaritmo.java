package edu.daniel.silva.Calculadora.process;

/**
 * Clase que calcula el logaritmo entero.
 */
public class Logaritmo {
    /**
     * Calcula cuántas veces se multiplica la base para llegar al argumento.
     * @param base Base del logaritmo.
     * @param argumento Número a calcular.
     * @return El logaritmo entero.
     */
    public static int realizarOperacion(int base, int argumento) {
        int conteo = 0;
        int acumulado = base;
        while (acumulado <= argumento) {
            acumulado = Multiplicacion.realizarOperacion(acumulado, base);
            conteo = Suma.realizarOperacion(conteo, 1);
        }
        return Suma.realizarOperacion(conteo, 1);
    }
}