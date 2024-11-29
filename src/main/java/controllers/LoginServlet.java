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
import java.io.PrintWriter;
import java.util.Optional;

@WebServlet({"/login", "/login.html"})
public class LoginServlet extends HttpServlet {
    final static String USERNAME = "vanship77";
    final static String PASSWORD = "vegetta777";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // LoginService para manejar la autenticación
        LoginService auth = new LoginServiceSessionImplement();
        Optional<String> usernameOptional = auth.getUsername(req);

        // Si el usuario ya ha iniciado sesión, muestra un mensaje de bienvenida
        if (usernameOptional.isPresent()) {
            resp.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = resp.getWriter()) {
                // Crea la plantilla HTML para el usuario autenticado
                out.print("<!DOCTYPE html>");
                out.println("<html lang='de'>");
                out.println("<head>");
                out.println("<meta charset='utf-8'>");
                out.println("<title>Hola " + usernameOptional.get() + "</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; background-color: #f3e5f5; padding: 20px; }");
                out.println("h1 { color: #6a1b9a; }");
                out.println("a { color: #6a1b9a; text-decoration: none; }");
                out.println("a:hover { text-decoration: underline; color: #ab47bc; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Hola " + usernameOptional.get() + ", ya has iniciado sesión anteriormente</h1>");
                out.println("<p><a href='" + req.getContextPath() + "/index.html'>Volver al inicio</a></p>");
                out.println("<p><a href='" + req.getContextPath() + "/logout'>Cerrar sesión</a></p>");
                out.println("</body>");
                out.println("</html>");
            }
        } else {
            // Si no hay sesión activa, redirige a la página de login
            getServletContext().getRequestDispatcher("/login.jsp").forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        // Verifica las credenciales
        if (USERNAME.equals(username) && PASSWORD.equals(password)) {
            // Crea la sesión y almacena el nombre de usuario
            HttpSession session = req.getSession();
            session.setAttribute("username", username);

            // Redirige al usuario a la página de inicio después del login exitoso
            resp.sendRedirect(req.getContextPath() + "/index.html");
        } else {
            // En caso de error, envia un mensaje de error
            resp.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Lo sentimos, no está autorizado para ingresar a esta página!");
        }
    }
}