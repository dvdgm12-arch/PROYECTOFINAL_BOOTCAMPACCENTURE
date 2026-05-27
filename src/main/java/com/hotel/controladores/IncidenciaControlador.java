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

import com.hotel.entidades.Incidencia;
import com.hotel.entidades.Habitacion;
import com.hotel.servicios.IncidenciaServicio;
import com.hotel.servicios.HabitacionServicio;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@Controller
@RequestMapping("/incidencias")
public class IncidenciaControlador {

    /** The incidencia servicio. */
    @Autowired
    private IncidenciaServicio incidenciaServicio;

    /** The habitacion servicio. */
    @Autowired
    private HabitacionServicio habitacionServicio;

    /**
     * Listar incidencias.
     *
     * @param numeroHabitacion the numero habitacion
     * @param estado the estado
     * @param modelo the modelo
     * @return the string
     */
    // LISTADO GENERAL
    @GetMapping
    public String listarIncidencias(
            @RequestParam(value = "numeroHabitacion", required = false) Integer numeroHabitacion,
            @RequestParam(value = "estado", required = false) String estado,
            Model modelo) {
        
        List<Incidencia> lista;
        
        if (numeroHabitacion != null || (estado != null && !estado.isEmpty())) {
            lista = incidenciaServicio.buscar(numeroHabitacion, estado);
        } else {
            lista = incidenciaServicio.obtenerTodas();
        }
        
        modelo.addAttribute("listaIncidencias", lista);
        modelo.addAttribute("numHabBusqueda", numeroHabitacion);
        modelo.addAttribute("estadoBusqueda", estado);
        
        return "Incidencias";
    }

    /**
     * Ver detalle.
     *
     * @param id the id
     * @param modelo the modelo
     * @return the string
     */
    // DETALLE DE INCIDENCIA
    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") int id, Model modelo) {
        Incidencia inc = incidenciaServicio.obtenerPorId(id);
        modelo.addAttribute("incidencia", inc);
        
        return "DetalleIncidencia";
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
        Incidencia nuevaInc = new Incidencia();
        
        nuevaInc.setId(0);
        
        // LLAMAMOS AL SERVICIO DE HABITACIONES PORQUE INCIDENCIA VA ASOCIADA A UNA HABITACION
        nuevaInc.setHabitacion(new Habitacion());
        List<Habitacion> habitaciones = habitacionServicio.obtenerTodas();
        
        modelo.addAttribute("incidencia", nuevaInc);
        modelo.addAttribute("listaHabitaciones", habitaciones);
        
        return "FormularioIncidencia";
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
    public String mostrarFormularioEdicion(@PathVariable("id") int id, Model modelo) {
        Incidencia incExistente = incidenciaServicio.obtenerPorId(id);
        
		if (incExistente.getHabitacion() == null) {
			incExistente.setHabitacion(new Habitacion());
		}
        
        List<Habitacion> habitaciones = habitacionServicio.obtenerTodas();
        
        modelo.addAttribute("incidencia", incExistente);
        modelo.addAttribute("listaHabitaciones", habitaciones);
        
        return "FormularioIncidencia";
    }

    /**
     * Guardar incidencia.
     *
     * @param laIncidencia the la incidencia
     * @return the string
     */
    // PROCESAR FORMULARIO
    @PostMapping("/guardar")
    public String guardarIncidencia(@ModelAttribute("incidencia") Incidencia laIncidencia, 
                                    @RequestParam("id") Integer id) {
        
        
        if (id != null && id > 0) {
            laIncidencia.setId(id);
        } else {
            
            laIncidencia.setId(null);
        }
        
        incidenciaServicio.guardar(laIncidencia);
        return "redirect:/incidencias";
    }

    /**
     * Eliminar incidencia.
     *
     * @param id the id
     * @return the string
     */
    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminarIncidencia(@PathVariable("id") int id) {
        incidenciaServicio.eliminar(id);
        return "redirect:/incidencias";
    }
}
