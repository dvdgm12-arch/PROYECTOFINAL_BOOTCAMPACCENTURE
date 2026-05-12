package com.hotel.servicios;

import java.util.List;
import com.hotel.entidades.Reserva;

public interface ReservaServicio {
    
    List<Reserva> obtenerTodos();
    Reserva obtenerPorId(Integer id);
    void guardar(Reserva reserva);
    void eliminar(Integer id);
}