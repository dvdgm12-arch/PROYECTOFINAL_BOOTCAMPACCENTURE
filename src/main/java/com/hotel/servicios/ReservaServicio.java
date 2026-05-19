package com.hotel.servicios;

import java.util.List;
import com.hotel.entidades.Reserva;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

public interface ReservaServicio {
    
    /**
     * Obtener todos.
     *
     * @return the list
     */
    List<Reserva> obtenerTodos();
    
    /**
     * Obtener por id.
     *
     * @param id the id
     * @return the reserva
     */
    Reserva obtenerPorId(Integer id);
    
    /**
     * Guardar.
     *
     * @param reserva the reserva
     */
    void guardar(Reserva reserva);
    
    /**
     * Eliminar.
     *
     * @param id the id
     */
    void eliminar(Integer id);
    
    /**
     * Buscar.
     *
     * @param dniHuesped the dni huesped
     * @param numeroHabitacion the numero habitacion
     * @return the list
     */
    List<Reserva> buscar(String dniHuesped, Integer numeroHabitacion);
}