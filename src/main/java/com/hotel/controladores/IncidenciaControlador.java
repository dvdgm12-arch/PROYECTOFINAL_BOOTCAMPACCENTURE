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

@Controller
@RequestMapping("/incidencias")
public class IncidenciaControlador {

    @Autowired
    private IncidenciaServicio incidenciaServicio;

    @Autowired
    private HabitacionServicio habitacionServicio;

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
        
      //PROBAR SIN ESTAR LOGEADOS
     /* java.util.Map<String, String> usuarioFalso = new java.util.HashMap<>();
        usuarioFalso.put("nombre", "Liante de Pruebas");
        usuarioFalso.put("rol", "recepcionista");
        modelo.addAttribute("usuarioSesion", usuarioFalso); */
     // A respetar en el login // Ejemplo de lo que deberás tener en el login: session.setAttribute("usuarioSesion", usuarioEncontrado);
        
        return "Incidencias";
    }

    // DETALLE DE INCIDENCIA
    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") int id, Model modelo) {
        Incidencia inc = incidenciaServicio.obtenerPorId(id);
        modelo.addAttribute("incidencia", inc);
        
     /* java.util.Map<String, String> usuarioFalso = new java.util.HashMap<>();
        usuarioFalso.put("rol", "recepcionista");
        modelo.addAttribute("usuarioSesion", usuarioFalso); */
        
        return "DetalleIncidencia";
    }

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
        
     /* java.util.Map<String, String> usuarioFalso = new java.util.HashMap<>();
        usuarioFalso.put("rol", "recepcionista");
        modelo.addAttribute("usuarioSesion", usuarioFalso); */
        
        return "FormularioIncidencia";
    }

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
        
     /* java.util.Map<String, String> usuarioFalso = new java.util.HashMap<>();
        usuarioFalso.put("rol", "recepcionista");
        modelo.addAttribute("usuarioSesion", usuarioFalso); */
        
        return "FormularioIncidencia";
    }

    // PROCESAR FORMULARIO
    @PostMapping(value = "/guardar", params = "!id")
    public String guardarIncidencia(@ModelAttribute("incidencia") Incidencia laIncidencia) {
        incidenciaServicio.guardar(laIncidencia);
        return "redirect:/incidencias";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminarIncidencia(@PathVariable("id") int id) {
        incidenciaServicio.eliminar(id);
        return "redirect:/incidencias";
    }
}
