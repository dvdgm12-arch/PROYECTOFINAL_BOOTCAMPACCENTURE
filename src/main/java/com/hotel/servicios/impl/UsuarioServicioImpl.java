package com.hotel.servicios.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.hotel.entidades.Usuario;
import com.hotel.repositorios.UsuarioRepositorio;
import com.hotel.servicios.UsuarioServicio;
import com.hotel.util.Encriptador;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    /** The usuario repositorio. */
    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    /**
     * Validar usuario.
     *
     * @param username the username
     * @param passwordPlano the password plano
     * @return the usuario
     */
    @Override
    @Transactional
    public Usuario validarUsuario(String username, String passwordPlano) {
        
        Usuario user = usuarioRepositorio.obtenerPorUsername(username);

        if (user != null && Encriptador.verificar(passwordPlano, user.getPassword())) {
            
            user.setUltimoLogin(new Date());
            usuarioRepositorio.actualizar(user);
            
            return user;
        }

        return null;
    }

    /**
     * Obtener por id.
     *
     * @param id the id
     * @return the usuario
     */
    @Override
    @Transactional(readOnly = true)
    public Usuario obtenerPorId(Integer id) {
        return usuarioRepositorio.obtenerPorId(id);
    }
}






