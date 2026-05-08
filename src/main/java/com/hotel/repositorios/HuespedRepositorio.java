package com.hotel.repositorios;

import java.util.List;
import com.hotel.entidades.Huesped;

public interface HuespedRepositorio {
    
    List<Huesped> obtenerTodas();
    
    Huesped obtenerPorId(int id);
    
    void guardar(Huesped huesped);
    
    void eliminar(int id);
}
