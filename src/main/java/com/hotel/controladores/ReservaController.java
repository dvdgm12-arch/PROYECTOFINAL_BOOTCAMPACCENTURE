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
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.entidades.Usuario;
import com.hotel.entidades.Usuario.PerfilUsuario;
import com.hotel.entidades.Reserva;
import com.hotel.servicios.ReservaServicio;
import com.hotel.servicios.HuespedServicio;
import com.hotel.servicios.HabitacionServicio;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    /** The reserva servicio. */
    @Autowired
    private ReservaServicio reservaServicio;

    /** The huesped servicio. */
    @Autowired
    private HuespedServicio huespedServicio;

    /** The habitacion servicio. */
    @Autowired
    private HabitacionServicio habitacionServicio;
    
    /**
     * Listar reservas.
     *
     * @param dniBusqueda the dni busqueda
     * @param habBusqueda the hab busqueda
     * @param modelo the modelo
     * @return the string
     */
    // LISTADO
    @GetMapping
    public String listarReservas(
            @RequestParam(value = "dniBusqueda", required = false) String dniBusqueda,
            @RequestParam(value = "habBusqueda", required = false) Integer habBusqueda,
            Model modelo) {
        
        List<Reserva> lista;
        
        if ((dniBusqueda != null && !dniBusqueda.isEmpty()) || habBusqueda != null) {
            lista = reservaServicio.buscar(dniBusqueda, habBusqueda);
        } else {
            lista = reservaServicio.obtenerTodos();
        }
        
        modelo.addAttribute("listaReservas", lista);
        modelo.addAttribute("dniFiltro", dniBusqueda);
        modelo.addAttribute("habFiltro", habBusqueda);
        
        return "Reservas";
    }
    
    /**
     * Ver detalle.
     *
     * @param id the id
     * @param modelo the modelo
     * @param sesion the sesion
     * @return the string
     */
    // DETALLE RESERVA
    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") Integer id, Model modelo, HttpSession sesion) {
        if (sesion.getAttribute("usuarioSesion") == null) return "redirect:/login";

        Reserva reserva = reservaServicio.obtenerPorId(id);
        modelo.addAttribute("reserva", reserva);
        return "DetalleReserva";
        
    }  
    
    /**
     * Mostrar formulario nuevo.
     *
     * @param modelo the modelo
     * @param sesion the sesion
     * @return the string
     */
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

    /**
     * Guardar reserva.
     *
     * @param reserva the reserva
     * @param sesion the sesion
     * @return the string
     */
    // GUARDAR RESERVA (ALTA Y MODIFICACIÓN)
    @PostMapping("/guardar")
    public String guardarReserva(@ModelAttribute("reserva") Reserva laReserva, 
                                 @RequestParam(value = "id", required = false) Integer id) {
        
        // Si viene un ID válido (mayor que 0), mantenemos el ID para la edición
        if (id != null && id > 0) {
            laReserva.setId(id);
        } else {
            // Si es 0, menor o null, es una alta nueva; forzamos null para activar el autoincremental de la BD
            laReserva.setId(null);
        }
        
        reservaServicio.guardar(laReserva);
        return "redirect:/reservas";
    }

    /**
     * Mostrar formulario editar.
     *
     * @param id the id
     * @param modelo the modelo
     * @param sesion the sesion
     * @return the string
     */
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
    
    /**
     * Eliminar reserva.
     *
     * @param id the id
     * @param sesion the sesion
     * @return the string
     */
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


 

