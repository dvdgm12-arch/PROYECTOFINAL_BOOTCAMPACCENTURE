package com.hotel.controladores;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.hotel.servicios.ReservaServicio;
import com.hotel.servicios.HabitacionServicio;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@Controller
public class NavigationController {

    /** The reserva servicio. */
    @Autowired
    private ReservaServicio reservaServicio;
    
    /** The habitacion servicio. */
    @Autowired
    private HabitacionServicio habitacionServicio;

    // MÉTODOS 1

    /**
     * Ver resumen ocupacion.
     *
     * @param modelo the modelo
     * @param sesion the sesion
     * @return the string
     */
    @GetMapping("/dashboard/resumen")
    public String verResumenOcupacion(Model modelo, HttpSession sesion) {
        if (sesion.getAttribute("usuarioSesion") == null) return "redirect:/login";
        
        int totalReservas = reservaServicio.obtenerTodos().size();
        int totalHabitaciones = habitacionServicio.obtenerTodas().size();
        
        modelo.addAttribute("totalReservas", totalReservas);
        modelo.addAttribute("totalHabitaciones", totalHabitaciones);
        
        return "DashboardOcupacion"; 
    }

    /**
     * Ver soporte.
     *
     * @param sesion the sesion
     * @return the string
     */
    @GetMapping("/contacto-soporte")
    public String verSoporte(HttpSession sesion) {
        if (sesion.getAttribute("usuarioSesion") == null) return "redirect:/login";
        return "SoporteTecnico";
    }
    
    // MÉTODOS 2
    
    /**
     * Ver guia usuario.
     *
     * @param sesion the sesion
     * @return the string
     */
    @GetMapping("/ayuda")
    public String verGuiaUsuario(HttpSession sesion) {
        if (sesion.getAttribute("usuarioSesion") == null) return "redirect:/login";
        return "GuiaUsuario";
    }

    /**
     * Ver terminos.
     *
     * @param sesion the sesion
     * @return the string
     */
    @GetMapping("/terminos-condiciones")
    public String verTerminos(HttpSession sesion) {
        if (sesion.getAttribute("usuarioSesion") == null) return "redirect:/login";
        return "TerminosLegales";
    }
}
