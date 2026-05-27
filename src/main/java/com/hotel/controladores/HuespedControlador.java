package com.hotel.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.entidades.Huesped;
import com.hotel.servicios.HuespedServicio;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@Controller
@RequestMapping("/huespedes")
public class HuespedControlador {

    /** The huesped servicio. */
    @Autowired
    private HuespedServicio huespedServicio;
    
    /**
     * Listar huespedes.
     *
     * @param nombre the nombre
     * @param dni the dni
     * @param modelo the modelo
     * @return the string
     */
    // LISTADO GENERAL Y FILTROS BÚSQUEDA
    @GetMapping
    public String listarHuespedes(
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "dni", required = false) String dni,
            Model modelo) {
        
        List<Huesped> lista;
        
        // FILTRAR
        if ((nombre != null && !nombre.isEmpty()) || (dni != null && !dni.isEmpty())) {
            lista = huespedServicio.buscar(nombre, dni);
        } else {
            lista = huespedServicio.obtenerTodas();
        }
        
        modelo.addAttribute("listaHuespedes", lista);
        
        modelo.addAttribute("nombreBusqueda", nombre);
        modelo.addAttribute("dniBusqueda", dni);
        
        return "Huespedes";
    }
    
    /**
     * Ver detalle.
     *
     * @param id the id
     * @param modelo the modelo
     * @return the string
     */
    // DETALLE DEL HUÉSPED
    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") Integer id, Model modelo) {
        Huesped h = huespedServicio.obtenerPorId(id);
        modelo.addAttribute("huesped", h);
        
        return "DetalleHuesped";
    }
    
    /**
     * Mostrar formulario alta.
     *
     * @param modelo the modelo
     * @return the string
     */
    // FORMULARIO (ALTA)
    @GetMapping("/nuevo")
    public String mostrarFormularioAlta(Model modelo) {
        Huesped nuevoHuesped = new Huesped();
        nuevoHuesped.setId(0);
        
        modelo.addAttribute("huesped", nuevoHuesped);
        
        return "FormularioHuesped";
    }
    
    /**
     * Mostrar formulario edicion.
     *
     * @param id the id
     * @param modelo the modelo
     * @return the string
     */
    // FORMULARIO (EDICIÓN)
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model modelo) {
        Huesped hExistente = huespedServicio.obtenerPorId(id);
        modelo.addAttribute("huesped", hExistente);
        
        return "FormularioHuesped";
    }
    
     /**
      * Guardar huesped.
      *
      * @param elHuesped the el huesped
      * @return the string
      */
     // PROCESAR FORMULARIO
    @PostMapping("/guardar")
	public String guardarHuesped(@ModelAttribute("huesped") Huesped elHuesped, @RequestParam("id") Integer id) {

		
		if (id != null && id > 0) {
			elHuesped.setId(id);
		} else {
			
			elHuesped.setId(null);
		}

		huespedServicio.guardar(elHuesped);
		return "redirect:/huespedes";
	}

    /**
     * Eliminar huesped.
     *
     * @param id the id
     * @return the string
     */
    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminarHuesped(@PathVariable("id") Integer id) {
        huespedServicio.eliminar(id);
        return "redirect:/huespedes";
    }
}