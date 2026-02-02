package edu.daniel.silva.actividad3.process;
import edu.daniel.silva.actividad3.models.Producto;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase para realizar operaciones estadisticas sobre una lista de empleados.
 */
public class ListaEmpleado {

    /** Ejercicio 5: Obtiene el empleado con el salario mas alto. */
    public Producto obtenerMayorSalario(List<Producto> lista) {
        Producto mayor = lista.get(0);
        for (Producto e : lista) if (e.getSalario() > mayor.getSalario()) mayor = e;
        return mayor;
    }

    /** Ejercicio 6: Encuentra la edad que mas veces se repite. */
    public int obtenerEdadComun(List<Producto> lista) {
        int moda = 0, maxFrec = 0;
        for (Producto e1 : lista) {
            int frec = 0;
            for (Producto e2 : lista) if (e1.getEdad() == e2.getEdad()) frec++;
            if (frec > maxFrec) { maxFrec = frec; moda = e1.getEdad(); }
        }
        return moda;
    }

    /** Ejercicio 7: Calcula el promedio de edad de todos los empleados. */
    public double promedioEdad(List<Producto> lista) {
        double suma = 0;
        for (Producto e : lista) suma += e.getEdad();
        return suma / lista.size();
    }

    /** Ejercicio 8: Calcula el promedio de salario de todos los empleados. */
    public double promedioSalario(List<Producto> lista) {
        double suma = 0;
        for (Producto e : lista) suma += e.getSalario();
        return suma / lista.size();
    }

    /** Ejercicio 9: Promedio de edad de quienes ganan mas de 25,000. */
    public double promedioEdadAltosSalarios(List<Producto> lista) {
        double suma = 0; int c = 0;
        for (Producto e : lista) if (e.getSalario() > 25000) { suma += e.getEdad(); c++; }
        return c == 0 ? 0 : suma / c;
    }

    /** Ejercicio 10: Filtra y devuelve empleados menores de 25 años. */
    public List<Producto> filtrarMenores25(List<Producto> lista) {
        List<Producto> res = new ArrayList<>();
        for (Producto e : lista) if (e.getEdad() < 25) res.add(e);
        return res;
    }

    /** Ejercicio 11: Cuenta empleados en el departamento de Sistemas. */
    public int contarSistemas(List<Producto> lista) {
        int c = 0;
        for (Producto e : lista) if (e.getDepartamento().equalsIgnoreCase("Sistemas")) c++;
        return c;
    }

    /** Ejercicio 14: Empleado con mayor salario que tenga mas de 30 años. */
    public Producto mayorSalarioMas30(List<Producto> lista) {
        Producto mayor = null;
        for (Producto e : lista) if (e.getEdad() > 30) {
            if (mayor == null || e.getSalario() > mayor.getSalario()) mayor = e;
        }
        return mayor;
    }

    /** Ejercicio 15: Empleado con menor salario y cuya edad sea la menos comun. */
    public Producto menorSalarioEdadRara(List<Producto> lista) {
        int edadRara = lista.get(0).getEdad();
        int minFrec = lista.size();
        for (Producto e1 : lista) {
            int f = 0;
            for (Producto e2 : lista) if (e1.getEdad() == e2.getEdad()) f++;
            if (f < minFrec) { minFrec = f; edadRara = e1.getEdad(); }
        }
        Producto res = null;
        for (Producto e : lista) if (e.getEdad() == edadRara) {
            if (res == null || e.getSalario() < res.getSalario()) res = e;
        }
        return res;
    }
}