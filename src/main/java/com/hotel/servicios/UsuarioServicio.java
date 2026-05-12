package com.hotel.servicios;

import com.hotel.entidades.Usuario;

public interface UsuarioServicio {

    Usuario validarUsuario(String username, String password);
    
    Usuario obtenerPorId(Integer id);
}

