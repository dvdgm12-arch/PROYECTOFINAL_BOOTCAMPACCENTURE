package com.hotel.controladores;

import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hotel.entidades.Habitacion;
import com.hotel.servicios.HabitacionServicio;

@Controller
@RequestMapping("/habitaciones")
public class HabitacionControlador {

    @Autowired
    private HabitacionServicio habitacionServicio;

    // LISTADO
    @GetMapping
    public String listarHabitaciones(Model modelo) {
        List<Habitacion> lista = habitacionServicio.obtenerTodas();
        modelo.addAttribute("listaHabitaciones", lista);
        return "Habitaciones"; 
    }

    // DETALLE
    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") int id, Model modelo) {
        Habitacion hab = habitacionServicio.obtenerPorId(id);
        modelo.addAttribute("habitacion", hab);
        return "DetalleHabitacion";
    }

    // MOSTRAR FORMULARIO (ALTA)
    @GetMapping("/nuevo")
    public String mostrarFormularioAlta(Model modelo) {
        Habitacion nuevaHab = new Habitacion();
        nuevaHab.setId(0); 
        modelo.addAttribute("habitacion", nuevaHab);
        return "FormularioHabitacion";
    }

    // MOSTRAR FORMULARIO (EDICIÓN)
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") int id, Model modelo) {
        Habitacion habExistente = habitacionServicio.obtenerPorId(id);
        modelo.addAttribute("habitacion", habExistente);
        return "FormularioHabitacion";
    }

    // PROCESAR FORMULARIO
    @PostMapping("/guardar")
    public String guardarHabitacion(@ModelAttribute("habitacion") Habitacion laHabitacion) {
        habitacionServicio.guardar(laHabitacion);
        return "redirect:/habitaciones";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminarHabitacion(@PathVariable("id") int id) {
        habitacionServicio.eliminar(id);
        return "redirect:/habitaciones";
    }
}

// A respetar en el login // Ejemplo de lo que deberás tener en el login: session.setAttribute("usuarioSesion", usuarioEncontrado);
