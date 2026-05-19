package com.hotel.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.entidades.Habitacion;
import com.hotel.repositorios.HabitacionRepositorio;
import com.hotel.servicios.HabitacionServicio;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@Service
public class HabitacionServicioImpl implements HabitacionServicio {

    /** The habitacion repositorio. */
    @Autowired
    private HabitacionRepositorio habitacionRepositorio;

    /**
     * Obtener todas.
     *
     * @return the list
     */
    @Override
    @Transactional
    public List<Habitacion> obtenerTodas() {
        return habitacionRepositorio.obtenerTodas();
    }

    /**
     * Obtener por id.
     *
     * @param id the id
     * @return the habitacion
     */
    @Override
    @Transactional
    public Habitacion obtenerPorId(int id) {
        return habitacionRepositorio.obtenerPorId(id);
    }

    /**
     * Guardar.
     *
     * @param habitacion the habitacion
     */
    @Override
    @Transactional
    public void guardar(Habitacion habitacion) {
        habitacionRepositorio.guardar(habitacion);
    }

    /**
     * Eliminar.
     *
     * @param id the id
     */
    @Override
    @Transactional
    public void eliminar(int id) {
        habitacionRepositorio.eliminar(id);
    }
    
    /**
     * Buscar.
     *
     * @param numero the numero
     * @param tipo the tipo
     * @return the list
     */
    @Override
    @Transactional(readOnly = true)
    public List<Habitacion> buscar(Integer numero, String tipo) {
        return habitacionRepositorio.buscar(numero, tipo);
    }
}
