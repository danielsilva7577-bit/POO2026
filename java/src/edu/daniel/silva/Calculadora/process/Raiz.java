package edu.daniel.silva.Calculadora.process;

/**
 * Clase que calcula la raíz cuadrada aproximada.
 */
public class Raiz {
    /**
     * Encuentra la raíz cuadrada entera mediante potencias sucesivas.
     * @param indice El índice de la raíz (ej. 2 para cuadrada).
     * @param radicando El número al que se le extrae la raíz.
     * @return La raíz positiva entera.
     */
    public static int realizarOperacion(int indice, int radicando) {
        int resultado = 0;
        while (Potencia.realizarOperacion(resultado, indice) <= radicando) {
            resultado = Suma.realizarOperacion(resultado, 1);
        }
        return Resta.realizarOperacion(resultado, 1);
    }
}