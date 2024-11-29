package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import service.LoginService;
import service.LoginServiceSessionImplement;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/logout")
public class Logout extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        LoginService auth = new LoginServiceSessionImplement();
        Optional<String> usernameOptional = auth.getUsername(req);

        try {
            if (usernameOptional.isPresent()) {
                HttpSession session = req.getSession();
                // Este método elimina la sesión del usuario
                session.invalidate();
            }
        } catch (Exception e) {
            // Manejo de excepciones, puedes registrar el error o redirigir a una página de error
            e.printStackTrace(); // Para fines de depuración, en producción podrías usar un logger
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al cerrar sesión.");
            return; // Salir del método en caso de error
        }

        // Redirigir al usuario a la página de login
        resp.sendRedirect(req.getContextPath() + "/login.html");
    }
}