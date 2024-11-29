package service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

import java.util.Optional;

public class LoginServiceSessionImplement implements LoginService {
    @Override
    public Optional<String> getUsername(HttpServletRequest request) {
        // Obtengo la sesión
        HttpSession session = request.getSession(false); // false para no crear una nueva sesión si no existe

        // Verifico si la sesión es nula
        if (session != null) {
            // Convierto el objeto de tipo sesión en String
            String username = (String) session.getAttribute("username");
            /*
             * Creo una condición en la cual valido
             * si al obtener el nombre del usuario es distinto de nulo
             * obtengo el username
             * Caso contrario devuelve la sesión vacía
             */
            return Optional.ofNullable(username); // Retorna un Optional que puede ser vacío
        }

        return Optional.empty(); // Retorna un Optional vacío si la sesión es nula
    }
}