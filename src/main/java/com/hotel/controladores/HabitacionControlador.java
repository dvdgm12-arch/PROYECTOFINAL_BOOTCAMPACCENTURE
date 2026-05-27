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

import com.hotel.entidades.Habitacion;
import com.hotel.servicios.HabitacionServicio;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@Controller
@RequestMapping("/habitaciones")
public class HabitacionControlador {

    /** The habitacion servicio. */
    @Autowired
    private HabitacionServicio habitacionServicio;

    /**
     * Listar habitaciones.
     *
     * @param numero the numero
     * @param tipo the tipo
     * @param modelo the modelo
     * @return the string
     */
    // LISTADO
    @GetMapping
    public String listarHabitaciones(
            @RequestParam(value = "numero", required = false) Integer numero,
            @RequestParam(value = "tipo", required = false) String tipo,
            Model modelo) {
        
        List<Habitacion> lista;
        
        if (numero != null || (tipo != null && !tipo.isEmpty())) {
            lista = habitacionServicio.buscar(numero, tipo);
        } else {
            lista = habitacionServicio.obtenerTodas();
        }
        
        modelo.addAttribute("listaHabitaciones", lista);
        modelo.addAttribute("numeroBusqueda", numero);
        modelo.addAttribute("tipoBusqueda", tipo);
        
        return "Habitaciones"; 
    }

    /**
     * Ver detalle.
     *
     * @param id the id
     * @param modelo the modelo
     * @return the string
     */
    // DETALLE
    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") int id, Model modelo) {
        Habitacion hab = habitacionServicio.obtenerPorId(id);
        modelo.addAttribute("habitacion", hab);
        return "DetalleHabitacion";
    }

    /**
     * Mostrar formulario alta.
     *
     * @param modelo the modelo
     * @return the string
     */
    // MOSTRAR FORMULARIO (ALTA)
    @GetMapping("/nuevo")
    public String mostrarFormularioAlta(Model modelo) {
        Habitacion nuevaHab = new Habitacion();
        nuevaHab.setId(0); 
        modelo.addAttribute("habitacion", nuevaHab);
        return "FormularioHabitacion";
    }

    /**
     * Mostrar formulario edicion.
     *
     * @param id the id
     * @param modelo the modelo
     * @return the string
     */
    // MOSTRAR FORMULARIO (EDICIÓN)
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") int id, Model modelo) {
        Habitacion habExistente = habitacionServicio.obtenerPorId(id);
        modelo.addAttribute("habitacion", habExistente);
        return "FormularioHabitacion";
    }

    /**
     * Guardar habitacion.
     *
     * @param laHabitacion the la habitacion
     * @return the string
     */
    // PROCESAR FORMULARIO
    @PostMapping("/guardar")
	public String guardarHabitacion(@ModelAttribute("habitacion") Habitacion laHabitacion,
			@RequestParam("id") Integer id) {


		if (id != null && id > 0) {
			laHabitacion.setId(id);
		} else {

			laHabitacion.setId(null);
		}

		habitacionServicio.guardar(laHabitacion);
		return "redirect:/habitaciones";
	}

    /**
     * Eliminar habitacion.
     *
     * @param id the id
     * @return the string
     */
    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminarHabitacion(@PathVariable("id") int id) {
        habitacionServicio.eliminar(id);
        return "redirect:/habitaciones";
    }
}


