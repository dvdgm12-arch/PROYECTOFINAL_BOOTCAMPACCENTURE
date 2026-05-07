package com.hotel.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.entidades.Habitacion;
import com.hotel.repositorios.HabitacionRepositorio;
import com.hotel.servicios.HabitacionServicio;

@Service
public class HabitacionServicioImpl implements HabitacionServicio {

    @Autowired
    private HabitacionRepositorio habitacionRepositorio;

    @Override
    @Transactional
    public List<Habitacion> obtenerTodas() {
        return habitacionRepositorio.obtenerTodas();
    }

    @Override
    @Transactional
    public Habitacion obtenerPorId(int id) {
        return habitacionRepositorio.obtenerPorId(id);
    }

    @Override
    @Transactional
    public void guardar(Habitacion habitacion) {
        habitacionRepositorio.guardar(habitacion);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        habitacionRepositorio.eliminar(id);
    }
}
