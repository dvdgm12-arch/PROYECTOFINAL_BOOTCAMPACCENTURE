package com.hotel.servicios;

import java.util.List;
import com.hotel.entidades.Habitacion;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

public interface HabitacionServicio {

    /**
     * Obtener todas.
     *
     * @return the list
     */
    List<Habitacion> obtenerTodas();

    /**
     * Obtener por id.
     *
     * @param id the id
     * @return the habitacion
     */
    Habitacion obtenerPorId(int id);

    /**
     * Guardar.
     *
     * @param habitacion the habitacion
     */
    void guardar(Habitacion habitacion);

    /**
     * Eliminar.
     *
     * @param id the id
     */
    void eliminar(int id);
    
    /**
     * Buscar.
     *
     * @param numero the numero
     * @param tipo the tipo
     * @return the list
     */
    List<Habitacion> buscar(Integer numero, String tipo);
}