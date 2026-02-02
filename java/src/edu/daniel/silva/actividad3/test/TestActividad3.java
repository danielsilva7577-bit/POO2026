package edu.daniel.silva.actividad3.test;

import edu.daniel.silva.actividad3.process.*;
import edu.daniel.silva.actividad3.models.Producto;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

/**
 * Pruebas unitarias para validar los 15 métodos requeridos.
 */
public class TestActividad3 {

    private final NumerosEnteros nEnteros = new NumerosEnteros();
    private final ManipuladorCadenas mCadenas = new ManipuladorCadenas();
    private final ListaEmpleado lEmpleado = new ListaEmpleado();

    // --- PRUEBAS DE NÚMEROS (NumerosEnteros.java) ---

    @Test
    public void testMoverCeros() {
        List<Integer> input = Arrays.asList(0, 2, 1, 4, 0, 2);
        List<Integer> output = Arrays.asList(2, 1, 4, 2, 0, 0);
        assertEquals(output, nEnteros.moverCeros(input));
    }

    @Test
    public void testContarPares() {
        List<Integer> input = Arrays.asList(3, 4, 5, 7, 6);
        assertEquals(2, nEnteros.contarPares(input));
    }

    // --- PRUEBAS DE CADENAS (ManipuladorCadenas.java) ---

    @Test
    public void testPalindromo() {
        assertTrue(mCadenas.esPalindromo("ana"));
        assertFalse(mCadenas.esPalindromo("hola mundo"));
    }

    @Test
    public void testContarVocales() {
        assertEquals(2, mCadenas.contarVocales("hola"));
    }

    @Test
    public void testInvertirCadena() {
        assertEquals("aloh", mCadenas.invertirCadena("hola"));
    }

    @Test
    public void testBuscarCaracter() {
        assertEquals(1, mCadenas.buscarCaracter("hola", 'o'));
        assertEquals(-1, mCadenas.buscarCaracter("hola", 'r'));
    }

    // --- PRUEBAS DE EMPLEADOS (ListaEmpleado.java) ---

    private List<Producto> getEjemplo() {
        return Arrays.asList(
                new Producto("Daniel", 23, 30000, "Sistemas"),
                new Producto("Ana", 20, 15000, "Ventas"),
                new Producto("Pedro", 35, 45000, "Sistemas"),
                new Producto("Luis", 20, 20000, "RH")
        );
    }

    @Test
    public void testMayorSalario() {
        assertEquals(45000, lEmpleado.obtenerMayorSalario(getEjemplo()).getSalario(), 0.1);
    }

    @Test
    public void testEdadComun() {
        assertEquals(20, lEmpleado.obtenerEdadComun(getEjemplo()));
    }

    @Test
    public void testPromedioEdad() {
        assertEquals(24.5, lEmpleado.promedioEdad(getEjemplo()), 0.1);
    }

    @Test
    public void testPromedioSalario() {
        assertEquals(27500.0, lEmpleado.promedioSalario(getEjemplo()), 0.1);
    }

    @Test
    public void testPromedioEdadGananMas25k() {
        assertEquals(29.0, lEmpleado.promedioEdadAltosSalarios(getEjemplo()), 0.1);
    }

    @Test
    public void testFiltrarMenores25() {
        assertEquals(3, lEmpleado.filtrarMenores25(getEjemplo()).size());
    }

    @Test
    public void testContarSistemas() {
        assertEquals(2, lEmpleado.contarSistemas(getEjemplo()));
    }

    @Test
    public void testMayorSalarioMas30() {
        assertEquals("Pedro", lEmpleado.mayorSalarioMas30(getEjemplo()).getNombre());
    }

    @Test
    public void testMenorSalarioEdadRara() {
        assertEquals("Daniel", lEmpleado.menorSalarioEdadRara(getEjemplo()).getNombre());
    }

}