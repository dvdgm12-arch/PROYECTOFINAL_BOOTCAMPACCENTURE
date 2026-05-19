package com.hotel.servicios.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hotel.entidades.Huesped;
import com.hotel.repositorios.HuespedRepositorio;
import com.hotel.servicios.HuespedServicio;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */

@Service
public class HuespedServicioImpl implements HuespedServicio {

	/** The huesped repositorio. */
	@Autowired
	private HuespedRepositorio huespedRepositorio;

	/**
	 * Obtener todas.
	 *
	 * @return the list
	 */
	@Override
	@Transactional
	public List<Huesped> obtenerTodas() {
		return huespedRepositorio.obtenerTodas();

	}

	/**
	 * Obtener por id.
	 *
	 * @param id the id
	 * @return the huesped
	 */
	@Override
	@Transactional
	public Huesped obtenerPorId(Integer id) {
		return huespedRepositorio.obtenerPorId(id);

	}

	/**
	 * Guardar.
	 *
	 * @param huesped the huesped
	 */
	@Override
	@Transactional
	public void guardar(Huesped huesped) {
		huespedRepositorio.guardar(huesped);

	}

	/**
	 * Eliminar.
	 *
	 * @param id the id
	 */
	@Override
	@Transactional
	public void eliminar(Integer id) {
		huespedRepositorio.eliminar(id);

	}

	/**
	 * Buscar.
	 *
	 * @param nombre the nombre
	 * @param dni    the dni
	 * @return the list
	 */
	@Override
	@Transactional(readOnly = true)
	public List<Huesped> buscar(String nombre, String dni) {
		return huespedRepositorio.buscar(nombre, dni);
	}

}



