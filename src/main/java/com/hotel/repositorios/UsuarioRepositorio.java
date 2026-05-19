package com.hotel.repositorios;

import com.hotel.entidades.Usuario;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

public interface UsuarioRepositorio {

   
    /**
     * Obtener por username.
     *
     * @param username the username
     * @return the usuario
     */
    Usuario obtenerPorUsername(String username);
    
    /**
     * Actualizar.
     *
     * @param usuario the usuario
     */
    void actualizar(Usuario usuario);
    
    /**
     * Obtener por id.
     *
     * @param id the id
     * @return the usuario
     */
    Usuario obtenerPorId(Integer id);
}
