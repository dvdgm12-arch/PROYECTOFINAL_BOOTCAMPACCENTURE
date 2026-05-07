package com.hotel.repositorios;

import java.util.List;
import com.hotel.entidades.Incidencia;

public interface IncidenciaRepositorio {

    List<Incidencia> obtenerTodas();
    
    Incidencia obtenerPorId(int id);
    
    void guardar(Incidencia incidencia);
    
    void eliminar(int id);
}
