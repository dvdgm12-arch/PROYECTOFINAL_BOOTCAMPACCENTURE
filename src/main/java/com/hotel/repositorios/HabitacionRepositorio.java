package com.hotel.repositorios;

import java.util.List;
import com.hotel.entidades.Habitacion;

public interface HabitacionRepositorio {
    
    List<Habitacion> obtenerTodas();
    
    Habitacion obtenerPorId(int id);
    
    void guardar(Habitacion habitacion);
    
    void eliminar(int id);
    
    List<Habitacion> buscar(Integer numero, String tipo);
}