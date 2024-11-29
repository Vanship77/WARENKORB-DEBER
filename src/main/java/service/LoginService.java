package service;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Optional;

/**
 * Interfaz para el servicio de gestión de inicio de sesión.
 */
public interface LoginService {

    /**
     * Obtiene el nombre de usuario de la solicitud HTTP si está presente.
     *
     * @param request La solicitud HTTP que contiene la información del usuario.
     * @return Un Optional que contiene el nombre de usuario si está presente, o vacío si no lo está.
     */
    Optional<String> getUsername(HttpServletRequest request);

    // Puedes agregar más métodos según sea necesario
    // Optional<User> login(String username, String password);
    // void logout(HttpServletRequest request);
    // boolean isLoggedIn(HttpServletRequest request);
}