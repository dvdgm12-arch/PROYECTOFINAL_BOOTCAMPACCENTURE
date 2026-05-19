package com.hotel.excepciones.handler;

import com.hotel.excepciones.AccesoDenegado;
import com.hotel.excepciones.EntidadNoEncontrada;
import com.hotel.excepciones.ReservaConflictiva;
import com.hotel.excepciones.OperacionNoPermitida;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@ControllerAdvice
public class ExcepcionesHandler {

    /**
     * Manejar entidad no encontrada.
     *
     * @param ex the ex
     * @param model the model
     * @return the string
     */
    // ERRORES DE BÚSQUEDA
    @ExceptionHandler(EntidadNoEncontrada.class)
    public String manejarEntidadNoEncontrada(EntidadNoEncontrada ex, Model model) {
        model.addAttribute("errorTitle", "No encontrado");
        model.addAttribute("mensaje", ex.getMessage());
        return "error"; // Nombre del archivo JSP: error.jsp
    }

    /**
     * Manejar acceso denegado.
     *
     * @param ex the ex
     * @param model the model
     * @return the string
     */
    // ERRORES DE PROBLEMAS DE SEGURIDAD
    @ExceptionHandler(AccesoDenegado.class)
    public String manejarAccesoDenegado(AccesoDenegado ex, Model model) {
        model.addAttribute("errorTitle", "Acceso Restringido");
        model.addAttribute("mensaje", "No tienes permisos para realizar esta acción.");
        return "error";
    }

    /**
     * Manejar errores negocio.
     *
     * @param ex the ex
     * @param model the model
     * @return the string
     */
    // ERRORES DE RESERVA Y OPERACIONES NO PERMITIDAS
    @ExceptionHandler({ReservaConflictiva.class, OperacionNoPermitida.class})
    public String manejarErroresNegocio(RuntimeException ex, Model model) {
        model.addAttribute("errorTitle", "Operación no válida");
        model.addAttribute("mensaje", ex.getMessage());
        return "error";
    }

    /**
     * Manejar error generico.
     *
     * @param ex the ex
     * @param model the model
     * @return the string
     */
    // CUALQUIER OTRO ERROR INESPERADO
    @ExceptionHandler(Exception.class)
    public String manejarErrorGenerico(Exception ex, Model model) {
        model.addAttribute("errorTitle", "Error Inesperado");
        model.addAttribute("mensaje", "Ha ocurrido un error en el sistema. Inténtelo más tarde.");
        return "error";
    }
    
    /**
     * Manejar 404.
     *
     * @param ex the ex
     * @param model the model
     * @return the string
     */
    // CONFIG VISTA error.JSP ANTE 404
    @ExceptionHandler(NoHandlerFoundException.class)
    public String manejar404(Exception ex, Model model) {
    	model.addAttribute("errorTitle", "¡Ups! Hemos tenido un problema");
        model.addAttribute("mensaje", "Parece que algo no ha ido bien en el Baratié");
        return "error";
    }
}
