package com.hotel.servicios;

import java.util.List;
import com.hotel.entidades.Incidencia;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

public interface IncidenciaServicio {

    /**
     * Obtener todas.
     *
     * @return the list
     */
    List<Incidencia> obtenerTodas();

    /**
     * Obtener por id.
     *
     * @param id the id
     * @return the incidencia
     */
    Incidencia obtenerPorId(int id);

    /**
     * Guardar.
     *
     * @param incidencia the incidencia
     */
    void guardar(Incidencia incidencia);

    /**
     * Eliminar.
     *
     * @param id the id
     */
    void eliminar(int id);
    
    /**
     * Buscar.
     *
     * @param numeroHabitacion the numero habitacion
     * @param estado the estado
     * @return the list
     */
    List<Incidencia> buscar(Integer numeroHabitacion, String estado);
}