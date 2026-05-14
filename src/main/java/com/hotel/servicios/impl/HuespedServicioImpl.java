package com.hotel.servicios.impl;

	
	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;


	import com.hotel.entidades.Huesped;
	import com.hotel.repositorios.HuespedRepositorio;
	import com.hotel.servicios.HuespedServicio;

	@Service
	public class HuespedServicioImpl implements HuespedServicio {

	    @Autowired
	    private HuespedRepositorio huespedRepositorio;

	    @Override
	    @Transactional
	    public List<Huesped> obtenerTodas() {
	    	return huespedRepositorio.obtenerTodas();
	    	
	    }
	    
	    @Override
	    @Transactional
	    public Huesped obtenerPorId(Integer id) {
	    	return huespedRepositorio.obtenerPorId(id);
	       
	    }

	    @Override
	    @Transactional
	    public void guardar(Huesped huesped) {
	    	 huespedRepositorio.guardar(huesped);
	    
	    }

	    @Override
	    @Transactional
	    public void eliminar(Integer id) {
	    	huespedRepositorio.eliminar(id);
	      
	    }
	    
	    @Override
	    @Transactional(readOnly = true) 
	    public List<Huesped> buscar(String nombre, String dni) {
	        return huespedRepositorio.buscar(nombre, dni);
	    }
	    
}



