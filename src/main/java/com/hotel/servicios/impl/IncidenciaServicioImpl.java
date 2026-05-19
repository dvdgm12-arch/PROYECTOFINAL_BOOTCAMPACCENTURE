package com.hotel.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.entidades.Incidencia;
import com.hotel.repositorios.IncidenciaRepositorio;
import com.hotel.servicios.IncidenciaServicio;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@Service
public class IncidenciaServicioImpl implements IncidenciaServicio {

    /** The incidencia repositorio. */
    @Autowired
    private IncidenciaRepositorio incidenciaRepositorio;

    /**
     * Obtener todas.
     *
     * @return the list
     */
    @Override
    @Transactional
    public List<Incidencia> obtenerTodas() {
        return incidenciaRepositorio.obtenerTodas();
    }

    /**
     * Obtener por id.
     *
     * @param id the id
     * @return the incidencia
     */
    @Override
    @Transactional
    public Incidencia obtenerPorId(int id) {
        return incidenciaRepositorio.obtenerPorId(id);
    }

    /**
     * Guardar.
     *
     * @param incidencia the incidencia
     */
    @Override
    @Transactional
    public void guardar(Incidencia incidencia) {
        incidenciaRepositorio.guardar(incidencia);
    }

    /**
     * Eliminar.
     *
     * @param id the id
     */
    @Override
    @Transactional
    public void eliminar(int id) {
        incidenciaRepositorio.eliminar(id);
    }
    
    /**
     * Buscar.
     *
     * @param numeroHabitacion the numero habitacion
     * @param estado the estado
     * @return the list
     */
    @Override
    @Transactional(readOnly = true)
    public List<Incidencia> buscar(Integer numeroHabitacion, String estado) {
        return incidenciaRepositorio.buscar(numeroHabitacion, estado);
    }
}
