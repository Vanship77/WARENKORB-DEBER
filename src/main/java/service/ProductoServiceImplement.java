package service;

import models.Productos;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImplement implements ProductoService {

    private List<Productos> productos;

    // Constructor para inicializar la lista de productos
    public ProductoServiceImplement() {
        this.productos = new ArrayList<>(Arrays.asList(
                new Productos(1L, "Laptop", "tecnología", 523.25),
                new Productos(2L, "Cocina", "hogar", 325.24),
                new Productos(3L, "Mouse", "tecnología", 15.25),
                new Productos(4L, "Teclado", "tecnología", 29.99),
                new Productos(5L, "Monitor", "tecnología", 199.99),
                new Productos(6L, "Impresora", "tecnología", 89.99),
                new Productos(7L, "Smartphone", "tecnología", 699.99),
                new Productos(8L, "Tablet", "tecnología", 299.99),
                new Productos(9L, "Auriculares", "tecnología", 49.99),
                new Productos(10L, "Raspberry Pi", "tecnología", 35.00),
                new Productos(11L, "Cámara Web", "tecnología", 45.00),
                new Productos(12L, "Disco Duro Externo", "tecnología", 89.99),
                new Productos(13L, "Router Wi-Fi", "tecnología", 59.99),
                new Productos(14L, "Smartwatch", "tecnología", 199.99),
                new Productos(15L, "Altavoz Bluetooth", "tecnología", 79.99),
                new Productos(16L, "Proyector", "tecnología", 299.99),
                new Productos(17L, "Tarjeta Gráfica", "tecnología", 499.99),
                new Productos(18L, "SSD", "tecnología", 99.99),
                new Productos(19L, "Gafas VR", "tecnología", 399.99),
                new Productos(20L, "Drone", "tecnología", 499.99),
                new Productos(21L, "Estación de Acoplamiento", "tecnología", 129.99)
        ));
    }

    @Override
    public List<Productos> listar() {
        return new ArrayList<>(productos); // Retorna una copia de la lista de productos
    }

    @Override
    public Optional<Productos> buscarPorId(Long idProducto) {
        if (idProducto == null) {
            return Optional.empty(); // Retorna vacío si el ID es nulo
        }
        return productos.stream()
                .filter(p -> p.getIdProducto().equals(idProducto)) // Suponiendo que Productos tiene un método getIdProducto()
                .findFirst(); // Busca el primer producto que coincida con el ID
    }

    @Override
    public Optional<Productos> agregarPorId(Long idProducto) {
        // Aquí puedes implementar la lógica para agregar un producto
        // Se podría buscar el producto y agregarlo a la lista si no existe
        Optional<Productos> productoOpt = buscarPorId(idProducto);
        if (productoOpt.isPresent()) {
            return productoOpt; // Retorna el producto si ya existe
        }

        // Aquí solo se retorna vacío como ejemplo
        return Optional.empty();
    }
}