package edu.daniel.silva.Calculadora.process;

/**
 * Clase que calcula la potencia mediante multiplicaciones sucesivas.
 */
public class Potencia {
    /**
     * Eleva una base a un exponente usando la clase Multiplicacion.
     * @param base Número base.
     * @param exponente Grado de la potencia.
     * @return Resultado de base elevado al exponente.
     */
    public static int realizarOperacion(int base, int exponente) {
        int resultado = 1;
        for (int i = 0; i < exponente; i++) {
            resultado = Multiplicacion.realizarOperacion(resultado, base);
        }
        return resultado;
    }
}