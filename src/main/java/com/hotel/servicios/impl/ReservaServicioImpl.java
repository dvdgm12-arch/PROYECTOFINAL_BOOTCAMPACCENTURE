package com.hotel.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.entidades.Reserva;
import com.hotel.repositorios.ReservaRepositorio;
import com.hotel.servicios.ReservaServicio;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@Service
public class ReservaServicioImpl implements ReservaServicio {

    /** The reserva repositorio. */
    @Autowired
    private ReservaRepositorio reservaRepositorio;

    /**
     * Obtener todos.
     *
     * @return the list
     */
    @Override
    @Transactional
    public List<Reserva> obtenerTodos() {
        return reservaRepositorio.obtenerTodos();
    }

    /**
     * Obtener por id.
     *
     * @param id the id
     * @return the reserva
     */
    @Override
    @Transactional
    public Reserva obtenerPorId(Integer id) {
        return reservaRepositorio.obtenerPorId(id);
    }

    /**
     * Guardar.
     *
     * @param reserva the reserva
     */
    @Override
    @Transactional
    public void guardar(Reserva reserva) {
        reservaRepositorio.guardar(reserva);
    }

    /**
     * Eliminar.
     *
     * @param id the id
     */
    @Override
    @Transactional
    public void eliminar(Integer id) {
        reservaRepositorio.eliminar(id);
    }
    
    /**
     * Buscar.
     *
     * @param dniHuesped the dni huesped
     * @param numeroHabitacion the numero habitacion
     * @return the list
     */
    @Override
    @Transactional(readOnly = true)
    public List<Reserva> buscar(String dniHuesped, Integer numeroHabitacion) {
        return reservaRepositorio.buscar(dniHuesped, numeroHabitacion);
    }
}