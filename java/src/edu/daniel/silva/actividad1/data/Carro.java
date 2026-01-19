package edu.daniel.silva.actividad1.data;

public class Carro {
    public String nombre;
    public double precio;
    public String caracteristicas;
    public String color = "Estándar";
    public String asientos = "Estándar";

    public Carro(String nombre, double precio, String caracteristicas) {
        this.nombre = nombre;
        this.precio = precio;
        this.caracteristicas = caracteristicas;

    }

    public void mostrarDetalles() {
        System.out.println("\n>>> INFO: " + nombre + " | $" + precio);
        System.out.println(">>> CARACTERÍSTICAS: " + caracteristicas);
    }


}