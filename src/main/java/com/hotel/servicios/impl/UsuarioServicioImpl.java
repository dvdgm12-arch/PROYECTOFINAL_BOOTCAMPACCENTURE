package com.hotel.servicios.impl;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.entidades.Usuario;
import com.hotel.repositorios.UsuarioRepositorio;
import com.hotel.servicios.UsuarioServicio;

@Service
public class UsuarioServicioImpl implements UsuarioServicio {

    @Autowired
    private UsuarioRepositorio usuarioRepositorio;

    @Override
    @Transactional
    public Usuario validarUsuario(String username, String password) {
        
        Usuario user = usuarioRepositorio.obtenerPorUsername(username);

        if (user != null && user.getPassword().equals(password)) {
            
            user.setUltimoLogin(new Date());
            usuarioRepositorio.actualizar(user);
            
            return user;
        }

        return null;
    }

    @Override
    @Transactional
    public Usuario obtenerPorId(Integer id) {
        return usuarioRepositorio.obtenerPorId(id);
    }
}







