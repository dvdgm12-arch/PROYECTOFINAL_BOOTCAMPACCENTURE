package com.hotel.servicios;

import java.util.List;
import com.hotel.entidades.Habitacion;

public interface HabitacionServicio {

    List<Habitacion> obtenerTodas();

    Habitacion obtenerPorId(int id);

    void guardar(Habitacion habitacion);

    void eliminar(int id);
}