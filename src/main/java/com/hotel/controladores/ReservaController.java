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

import com.hotel.entidades.Usuario;
import com.hotel.entidades.Usuario.PerfilUsuario;
import com.hotel.entidades.Reserva;
import com.hotel.servicios.ReservaServicio;
import com.hotel.servicios.HuespedServicio;
import com.hotel.servicios.HabitacionServicio;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaServicio reservaServicio;

    @Autowired
    private HuespedServicio huespedServicio;

    @Autowired
    private HabitacionServicio habitacionServicio;
    
    // LISTADO
    @GetMapping
    public String listarReservas(Model modelo, HttpSession sesion) {
        if (sesion.getAttribute("usuarioSesion") == null) return "redirect:/login";
        
        modelo.addAttribute("listaReservas", reservaServicio.obtenerTodos());
        return "Reservas";
    }
    
    // DETALLE RESERVA
    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") Integer id, Model modelo, HttpSession sesion) {
        if (sesion.getAttribute("usuarioSesion") == null) return "redirect:/login";

        Reserva reserva = reservaServicio.obtenerPorId(id);
        modelo.addAttribute("reserva", reserva);
        return "DetalleReserva";
        
    }  
    
    // FORMULARIO (ALTA)
    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model modelo, HttpSession sesion) {
        Usuario usuarioSesion = (Usuario) sesion.getAttribute("usuarioSesion");
        if (usuarioSesion == null) return "redirect:/login";
        
        // CONTROL DE ACCESO
        if (usuarioSesion.getRol() != PerfilUsuario.recepcionista) {
            return "redirect:/login/principal?error=acceso-denegado";
        }

        modelo.addAttribute("reserva", new Reserva());
        modelo.addAttribute("listaHuespedes", huespedServicio.obtenerTodas());
        modelo.addAttribute("listaHabitaciones", habitacionServicio.obtenerTodas());
        return "FormularioReserva";
    }

    // GUARDAR RESERVA (ALTA Y MODIFICACIÓN)
    @PostMapping(value = "/guardar", params = "!id")
    public String guardarReserva(@ModelAttribute("reserva") Reserva reserva, HttpSession sesion) {
        Usuario usuarioSesion = (Usuario) sesion.getAttribute("usuarioSesion");
        if (usuarioSesion == null || usuarioSesion.getRol() != PerfilUsuario.recepcionista) {
            return "redirect:/login/principal?error=acceso-denegado";
        }

        reservaServicio.guardar(reserva);
        return "redirect:/reservas";
    }

    // MODIFICAR RESERVA
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Integer id, Model modelo, HttpSession sesion) {
        Usuario usuarioSesion = (Usuario) sesion.getAttribute("usuarioSesion");
        if (usuarioSesion == null || usuarioSesion.getRol() != PerfilUsuario.recepcionista) {
            return "redirect:/login/principal?error=acceso-denegado";
        }

        Reserva reserva = reservaServicio.obtenerPorId(id);
        modelo.addAttribute("reserva", reserva);
        modelo.addAttribute("listaHuespedes", huespedServicio.obtenerTodas());
        modelo.addAttribute("listaHabitaciones", habitacionServicio.obtenerTodas());
        return "FormularioReserva";
    }
    
    // ELIMINAR RESERVA
    @GetMapping("/eliminar/{id}")
    public String eliminarReserva(@PathVariable("id") Integer id, HttpSession sesion) {
        Usuario usuarioSesion = (Usuario) sesion.getAttribute("usuarioSesion");
        if (usuarioSesion == null || usuarioSesion.getRol() != PerfilUsuario.recepcionista) {
            return "redirect:/login/principal?error=acceso-denegado";
        }

        reservaServicio.eliminar(id);
        return "redirect:/reservas";
    }
}


 

