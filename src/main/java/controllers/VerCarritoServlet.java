package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Carrito; // Asegúrate de que la clase Carrito esté en el paquete correcto

import java.io.IOException;

@WebServlet("/ver-carrito")
public class VerCarritoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            // Obtener el carrito de compras de la sesión
            Carrito carrito = (Carrito) req.getSession().getAttribute("carrito");

            // Si el carrito es nulo, inicializar uno nuevo
            if (carrito == null) {
                carrito = new Carrito();
                req.getSession().setAttribute("carrito", carrito);
            }

            // Añadir el carrito a la solicitud para que esté disponible en la vista
            req.setAttribute("carrito", carrito);

            // Redirigir a la página del carrito
            getServletContext().getRequestDispatcher("/carrito.jsp").forward(req, resp);
        } catch (Exception e) {
            // Manejo de excepciones, puedes registrar el error o redirigir a una página de error
            e.printStackTrace(); // Para fines de depuración, en producción podrías usar un logger
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud.");
        }
    }
}