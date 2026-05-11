package com.hotel.servicios;

import java.util.List;
import com.hotel.entidades.Huesped;

public interface HuespedServicio{

    
    List<Huesped> obtenerTodas();
    
    Huesped obtenerPorId(Integer id);
    
    void guardar(Huesped huesped);
    
    void eliminar(Integer id);
}
