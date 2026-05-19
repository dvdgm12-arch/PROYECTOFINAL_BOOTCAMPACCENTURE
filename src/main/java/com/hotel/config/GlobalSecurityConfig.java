package com.hotel.config;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */

@ControllerAdvice
public class GlobalSecurityConfig {

    /**
     * Inits the binder.
     *
     * @param binder the binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // PROTECCION A CAMPOS ID EN TODOS LOS FORMULARIOS
        // APLICA A TODOS LOS FORMULARIOS
        binder.setDisallowedFields("id");
    }
}