package service;

import models.Productos;

import java.util.List;
import java.util.Optional;

/**
 * Interfaz para el servicio de gestión de productos.
 */
public interface ProductoService {

    /**
     * Lista todos los productos disponibles.
     *
     * @return Una lista de productos.
     */
    List<Productos> listar();

    /**
     * Busca un producto por su ID.
     *
     * @param idProducto El ID del producto a buscar.
     * @return Un Optional que contiene el producto si se encuentra, o vacío si no se encuentra.
     */
    Optional<Productos> buscarPorId(Long idProducto);

    /**
     * Agrega un producto por su ID.
     *
     * @param idProducto El ID del producto a agregar.
     * @return Un Optional que contiene el producto agregado si la operación fue exitosa, o vacío si no se encontró el producto.
     */
    Optional<Productos> agregarPorId(Long idProducto);

    // Puedes agregar más métodos según sea necesario
    // Optional<Productos> eliminarPorId(Long idProducto);
    // Optional<Productos> actualizar(Productos producto);
}