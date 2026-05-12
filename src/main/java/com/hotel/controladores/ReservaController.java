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
 }