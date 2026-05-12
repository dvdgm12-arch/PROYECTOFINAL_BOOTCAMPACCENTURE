
package com.hotel.repositorios;

import com.hotel.entidades.Usuario;

public interface UsuarioRepositorio {

   
    Usuario obtenerPorUsername(String username);
    
    void actualizar(Usuario usuario);
    
    Usuario obtenerPorId(Integer id);
}
