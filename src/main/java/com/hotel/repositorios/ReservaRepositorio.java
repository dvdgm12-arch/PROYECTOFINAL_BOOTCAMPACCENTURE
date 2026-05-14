package com.hotel.repositorios;

import java.util.List;
import com.hotel.entidades.Reserva;

public interface ReservaRepositorio {
    
    List<Reserva> obtenerTodos();
    
    Reserva obtenerPorId(Integer id);
    
    void guardar(Reserva reserva);
    
    void eliminar(Integer id);
    
    List<Reserva> buscar(String dniHuesped, Integer numeroHabitacion);
}