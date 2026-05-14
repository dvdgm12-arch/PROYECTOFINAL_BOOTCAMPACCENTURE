package com.hotel.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.entidades.Reserva;
import com.hotel.repositorios.ReservaRepositorio;
import com.hotel.servicios.ReservaServicio;

@Service
public class ReservaServicioImpl implements ReservaServicio {

    @Autowired
    private ReservaRepositorio reservaRepositorio;

    @Override
    @Transactional
    public List<Reserva> obtenerTodos() {
        return reservaRepositorio.obtenerTodos();
    }

    @Override
    @Transactional
    public Reserva obtenerPorId(Integer id) {
        return reservaRepositorio.obtenerPorId(id);
    }

    @Override
    @Transactional
    public void guardar(Reserva reserva) {
        reservaRepositorio.guardar(reserva);
    }

    @Override
    @Transactional
    public void eliminar(Integer id) {
        reservaRepositorio.eliminar(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Reserva> buscar(String dniHuesped, Integer numeroHabitacion) {
        return reservaRepositorio.buscar(dniHuesped, numeroHabitacion);
    }
}