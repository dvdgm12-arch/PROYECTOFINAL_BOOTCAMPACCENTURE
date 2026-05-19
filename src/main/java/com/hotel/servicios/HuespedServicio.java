package com.hotel.servicios;

import java.util.List;
import com.hotel.entidades.Huesped;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

public interface HuespedServicio{

    
    /**
     * Obtener todas.
     *
     * @return the list
     */
    List<Huesped> obtenerTodas();
    
    /**
     * Obtener por id.
     *
     * @param id the id
     * @return the huesped
     */
    Huesped obtenerPorId(Integer id);
    
    /**
     * Guardar.
     *
     * @param huesped the huesped
     */
    void guardar(Huesped huesped);
    
    /**
     * Eliminar.
     *
     * @param id the id
     */
    void eliminar(Integer id);

	/**
	 * Buscar.
	 *
	 * @param nombre the nombre
	 * @param dni the dni
	 * @return the list
	 */
	List<Huesped> buscar(String nombre, String dni);
}
