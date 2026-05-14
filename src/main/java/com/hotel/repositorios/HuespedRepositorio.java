package com.hotel.repositorios;

import java.util.List;
import com.hotel.entidades.Huesped;

public interface HuespedRepositorio {
    
    List<Huesped> obtenerTodas();
    
    Huesped obtenerPorId(Integer id);
    
    void guardar(Huesped huesped);
    
    void eliminar(Integer id);

    // BÚSQUEDA
    List<Huesped> buscar(String nombre, String dni);
}
