package models;

import java.util.Objects;

public class ItemsCarrito {
    private int cantidad;
    private Productos productos;

    // Constructor
    public ItemsCarrito(int cantidad, Productos productos) {
        this.cantidad = cantidad;
        this.productos = productos;
    }

    // Getters y Setters
    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no puede ser negativa");
        }
        this.cantidad = cantidad;
    }

    public Productos getProductos() {
        return productos;
    }

    public void setProductos(Productos productos) {
        this.productos = productos;
    }

    // Método equals para comparar ItemsCarrito
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsCarrito that = (ItemsCarrito) o;
        return Objects.equals(productos.getIdProducto(), that.productos.getIdProducto());
    }

    // Método hashCode para asegurar la coherencia con equals
    @Override
    public int hashCode() {
        return Objects.hash(productos.getIdProducto());
    }

    // Método para calcular el subtotal
    public double getSubtotal() {
        return cantidad * productos.getPrecio(); // Cambiado a getSubtotal
    }
}