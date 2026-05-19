package com.hotel.servicios;

import com.hotel.entidades.Usuario;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

public interface UsuarioServicio {

    /**
     * Validar usuario.
     *
     * @param username the username
     * @param password the password
     * @return the usuario
     */
    Usuario validarUsuario(String username, String password);
    
    /**
     * Obtener por id.
     *
     * @param id the id
     * @return the usuario
     */
    Usuario obtenerPorId(Integer id);
}

