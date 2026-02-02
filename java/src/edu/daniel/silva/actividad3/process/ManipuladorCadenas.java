package edu.daniel.silva.actividad3.process;

/**
 * Clase para el procesamiento y analisis de cadenas de texto.
 */
public class ManipuladorCadenas {

    /**
     * Ejercicio 3: Determina si un texto es palindromo.
     * @param texto Cadena a evaluar.
     * @return true si se lee igual de ambos lados.
     */
    public boolean esPalindromo(String texto) {
        String limpia = texto.replace(" ", "").toLowerCase();
        String invertida = invertirCadena(limpia);
        return limpia.equals(invertida);
    }

    /**
     * Ejercicio 4: Cuenta cuantas vocales tiene un String.
     * @param texto Cadena de entrada.
     * @return Numero de vocales encontradas.
     */
    public int contarVocales(String texto) {
        int cuenta = 0;
        String t = texto.toLowerCase();
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if ("aeiou".indexOf(c) != -1) cuenta++;
        }
        return cuenta;
    }

    /**
     * Ejercicio 12: Invierte una cadena sin usar metodos prohibidos.
     * @param texto Cadena original.
     * @return Cadena al reves.
     */
    public String invertirCadena(String texto) {
        String res = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            res += texto.charAt(i);
        }
        return res;
    }

    /**
     * Ejercicio 13: Busca la posicion de un caracter sin usar indexOf.
     * @param texto Cadena donde buscar.
     * @param letra Caracter a encontrar.
     * @return Indice de la primera aparicion o -1 si no existe.
     */
    public int buscarCaracter(String texto, char letra) {
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == letra) return i;
        }
        return -1;
    }

}