package com.hotel.controladores;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hotel.servicios.ReservaServicio;
import com.hotel.servicios.HabitacionServicio;

@Controller
public class NavigationController {

    @Autowired
    private ReservaServicio reservaServicio;
    
    @Autowired
    private HabitacionServicio habitacionServicio;

    // MÉTODOS 1

    @GetMapping("/dashboard/resumen")
    public String verResumenOcupacion(Model modelo, HttpSession sesion) {
        if (sesion.getAttribute("usuarioSesion") == null) return "redirect:/login";
        
        int totalReservas = reservaServicio.obtenerTodos().size();
        int totalHabitaciones = habitacionServicio.obtenerTodas().size();
        
        modelo.addAttribute("totalReservas", totalReservas);
        modelo.addAttribute("totalHabitaciones", totalHabitaciones);
        
        return "DashboardOcupacion"; 
    }

    @GetMapping("/contacto-soporte")
    public String verSoporte(HttpSession sesion) {
        if (sesion.getAttribute("usuarioSesion") == null) return "redirect:/login";
        return "SoporteTecnico";
    }
    
    // MÉTODOS 2
    
    @GetMapping("/ayuda")
    public String verGuiaUsuario(HttpSession sesion) {
        if (sesion.getAttribute("usuarioSesion") == null) return "redirect:/login";
        return "GuiaUsuario";
    }

    @GetMapping("/terminos-condiciones")
    public String verTerminos(HttpSession sesion) {
        if (sesion.getAttribute("usuarioSesion") == null) return "redirect:/login";
        return "TerminosLegales";
    }
}
