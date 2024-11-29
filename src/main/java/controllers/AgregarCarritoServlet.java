package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import models.Carrito;
import models.ItemsCarrito;
import models.Productos;
import service.ProductoService;
import service.ProductoServiceImplement;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/agregar-carrito")
public class AgregarCarritoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Obtiene el ID del producto desde la solicitud
        Long idProducto = Long.parseLong(req.getParameter("idProducto"));
        ProductoService service = new ProductoServiceImplement();

        // Intenta agregar el producto por ID
        Optional<Productos> producto = service.agregarPorId(idProducto);

        // Verifica si el producto existe
        if (producto.isPresent()) {
            ItemsCarrito item = new ItemsCarrito(1, producto.get());
            HttpSession session = req.getSession();
            Carrito carrito;

            // Verifica si ya existe un carrito en la sesión
            if (session.getAttribute("carrito") == null) {
                carrito = new Carrito();
                session.setAttribute("carrito", carrito);
            } else {
                carrito = (Carrito) session.getAttribute("carrito");
            }

            // Agrega el item al carrito
            carrito.addItemsCarrito(item);
        } else {
            // Manejo de error si el producto no existe
            resp.sendError(HttpServletResponse.SC_NOT_FOUND, "Producto no encontrado.");
            return; // Salir del método después de manejar el error
        }

        // Redirige a la página de ver carrito
        resp.sendRedirect(req.getContextPath() + "/ver-carrito");
    }
}