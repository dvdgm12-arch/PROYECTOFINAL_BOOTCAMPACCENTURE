package com.hotel.config;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

@ControllerAdvice
public class GlobalSecurityConfig {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // PROTECCION A CAMPOS ID EN TODOS LOS FORMULARIOS
        // APLICA A TODOS LOS FORMULARIOS
        binder.setDisallowedFields("id");
    }
}