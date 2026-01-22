package edu.daniel.silva.Calculadora.process;

/**
 * Clase que realiza la multiplicación mediante sumas sucesivas.
 */
public class Multiplicacion {
    /**
     * Multiplica dos números usando la clase Suma.
     * @param a Multiplicando.
     * @param b Multiplicador.
     * @return El producto de a y b.
     */
    public static int realizarOperacion(int a, int b) {
        int resultado = 0;
        for (int i = 0; i < b; i++) {
            resultado = Suma.realizarOperacion(resultado, a);
        }
        return resultado;
    }
}