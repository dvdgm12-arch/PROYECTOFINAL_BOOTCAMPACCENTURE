package com.hotel.servicios.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.entidades.Incidencia;
import com.hotel.repositorios.IncidenciaRepositorio;
import com.hotel.servicios.IncidenciaServicio;

@Service
public class IncidenciaServicioImpl implements IncidenciaServicio {

    @Autowired
    private IncidenciaRepositorio incidenciaRepositorio;

    @Override
    @Transactional
    public List<Incidencia> obtenerTodas() {
        return incidenciaRepositorio.obtenerTodas();
    }

    @Override
    @Transactional
    public Incidencia obtenerPorId(int id) {
        return incidenciaRepositorio.obtenerPorId(id);
    }

    @Override
    @Transactional
    public void guardar(Incidencia incidencia) {
        incidenciaRepositorio.guardar(incidencia);
    }

    @Override
    @Transactional
    public void eliminar(int id) {
        incidenciaRepositorio.eliminar(id);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Incidencia> buscar(Integer numeroHabitacion, String estado) {
        return incidenciaRepositorio.buscar(numeroHabitacion, estado);
    }
}
