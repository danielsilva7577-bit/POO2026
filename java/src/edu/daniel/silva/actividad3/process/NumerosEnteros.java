package edu.daniel.silva.actividad3.process;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que realiza calculos y operaciones con listas de numeros enteros.
 */
public class NumerosEnteros {

    /**
     * Ejercicio 1: Recorre todos los ceros al final de la lista.
     * @param lista Lista de entrada con ceros.
     * @return Lista con los ceros desplazados a la derecha.
     */
    public List<Integer> moverCeros(List<Integer> lista) {
        List<Integer> resultado = new ArrayList<>();
        for (int n : lista) {
            if (n != 0) resultado.add(n);
        }
        while (resultado.size() < lista.size()) {
            resultado.add(0);
        }
        return resultado;
    }

    /**
     * Ejercicio 2: Cuenta la cantidad de numeros pares.
     * @param lista Lista de numeros enteros.
     * @return Conteo total de pares.
     */
    public int contarPares(List<Integer> lista) {
        int cuenta = 0;
        for (int n : lista) {
            if (n % 2 == 0) cuenta++;
        }
        return cuenta;
    }

}