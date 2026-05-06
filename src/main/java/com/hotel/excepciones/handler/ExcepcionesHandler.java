package com.hotel.excepciones.handler;

import com.hotel.excepciones.AccesoDenegado;
import com.hotel.excepciones.EntidadNoEncontrada;
import com.hotel.excepciones.ReservaConflictiva;
import com.hotel.excepciones.OperacionNoPermitida;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcepcionesHandler {

    // ERRORES DE BÚSQUEDA
    @ExceptionHandler(EntidadNoEncontrada.class)
    public String manejarEntidadNoEncontrada(EntidadNoEncontrada ex, Model model) {
        model.addAttribute("errorTitle", "No encontrado");
        model.addAttribute("mensaje", ex.getMessage());
        return "error"; // Nombre del archivo JSP: error.jsp
    }

    // ERRORES DE PROBLEMAS DE SEGURIDAD
    @ExceptionHandler(AccesoDenegado.class)
    public String manejarAccesoDenegado(AccesoDenegado ex, Model model) {
        model.addAttribute("errorTitle", "Acceso Restringido");
        model.addAttribute("mensaje", "No tienes permisos para realizar esta acción.");
        return "error";
    }

    // ERRORES DE RESERVA Y OPERACIONES NO PERMITIDAS
    @ExceptionHandler({ReservaConflictiva.class, OperacionNoPermitida.class})
    public String manejarErroresNegocio(RuntimeException ex, Model model) {
        model.addAttribute("errorTitle", "Operación no válida");
        model.addAttribute("mensaje", ex.getMessage());
        return "error";
    }

    // CUALQUIER OTRO ERROR INESPERADO
    @ExceptionHandler(Exception.class)
    public String manejarErrorGenerico(Exception ex, Model model) {
        model.addAttribute("errorTitle", "Error Inesperado");
        model.addAttribute("mensaje", "Ha ocurrido un error en el sistema. Inténtelo más tarde.");
        return "error";
    }
}
