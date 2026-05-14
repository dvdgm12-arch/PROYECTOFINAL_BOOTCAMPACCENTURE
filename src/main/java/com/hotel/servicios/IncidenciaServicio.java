package com.hotel.servicios;

import java.util.List;
import com.hotel.entidades.Incidencia;

public interface IncidenciaServicio {

    List<Incidencia> obtenerTodas();

    Incidencia obtenerPorId(int id);

    void guardar(Incidencia incidencia);

    void eliminar(int id);
    
    List<Incidencia> buscar(Integer numeroHabitacion, String estado);
}