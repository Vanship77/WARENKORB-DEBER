package controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import models.Productos;
import service.LoginService;
import service.LoginServiceSessionImplement;
import service.ProductoService;
import service.ProductoServiceImplement;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Optional;

@WebServlet("/productos")
public class ProductosServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ProductoService servicios = new ProductoServiceImplement();
        List<Productos> productos = servicios.listar();

        LoginService auth = new LoginServiceSessionImplement();
        Optional<String> usernameOptional = auth.getUsername(req);

        resp.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = resp.getWriter()) {
            // Crear la plantilla HTML
            out.print("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"utf-8\">");
            out.println("<title>Listado de Productos</title>");
            // Estilos CSS
            out.println("<style>");
            out.println("body {");
            out.println("    font-family: Arial, sans-serif;");
            out.println("    background-color: #f3e5f5;"); // Color de fondo suave
            out.println("    margin: 0;");
            out.println("    padding: 20px;");
            out.println("}");
            out.println("h1 {");
            out.println("    color: #6a1b9a;"); // Color morado para el título
            out.println("    text-align: center;");
            out.println("}");
            out.println("table {");
            out.println("    width: 100%;");
            out.println("    border-collapse: collapse;");
            out.println("    margin-top: 20px;");
            out.println("}");
            out.println("th, td {");
            out.println("    border: 1px solid #6a1b9a;"); // Borde morado
            out.println("    padding: 10px;");
            out.println("    text-align: left;");
            out.println("}");
            out.println("th {");
            out.println("    background-color: #ab47bc;"); // Color de fondo de encabezado
            out.println("    color: white;");
            out.println("}");
            out.println("tr:nth-child(even) {");
            out.println("    background-color: #e1bee7;"); // Color de fondo alternativo para filas
            out.println("}");
            out.println("a {");
            out.println("    color: #6a1b9a;"); // Color de los enlaces
            out.println("    text-decoration: none;");
            out.println("}");
            out.println("a:hover {");
            out.println("    text-decoration: underline;"); // Subrayado en hover
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Listado de productos</h1>");

            // Mensaje de bienvenida si el usuario está autenticado
            usernameOptional.ifPresent(username ->
                    out.println("<div style='color:blue;'>Hola " + username + ", Bienvenido</div>")
            );

            // Crea la tabla de productos
            out.println("<table>"); // Añade un borde a la tabla para mejor visualización
            out.println("<tr>");
            out.println("<th>ID PRODUCTO</th>");
            out.println("<th>NOMBRE</th>");
            out.println("<th>CATEGORIA</th>");
            if (usernameOptional.isPresent()) {
                out.println("<th>PRECIO</th>");
                out.println("<th>AGREGAR</th>");
            }
            out.println("</tr>");

            // Iterar sobre la lista de productos
            for (Productos pr : productos) {
                out.println("<tr>");
                out.println("<td>" + pr.getIdProducto() + "</td>");
                out.println("<td>" + pr.getNombre() + "</td>");
                out.println("<td>" + pr.getCategoria() + "</td>");
                if (usernameOptional.isPresent()) {
                    out.println("<td>" + pr.getPrecio() + "</td>");
                    out.println("<td><a href=\"" + req.getContextPath() + "/agregar-carrito?idProducto=" + pr.getIdProducto() + "\">Agregar carrito</a></td>");
                }
                out.println("</tr>");
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        } catch (Exception e) {
            // Manejo de excepciones
            e.printStackTrace(); // Para fines de depuración, en producción podrías usar un logger
            resp.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud.");
        }
    }
}