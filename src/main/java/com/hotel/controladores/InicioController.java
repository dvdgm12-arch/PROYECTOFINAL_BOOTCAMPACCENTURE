package com.hotel.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@Controller
public class InicioController {

	/**
	 * Mostrar inicio.
	 *
	 * @return the string
	 */
	@RequestMapping("/")
	public String mostrarInicio() {
	    return "inicio"; 
	}
}
