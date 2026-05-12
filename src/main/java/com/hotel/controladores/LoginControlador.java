package com.hotel.controladores;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.entidades.Usuario;
import com.hotel.servicios.UsuarioServicio;

@Controller
@RequestMapping("/login")
public class LoginControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    // MOSTRAR FORMULARIO
    @GetMapping
    public String mostrarLogin() {
        return "Login";
    }

    // PROCESAR FORMULARIO
    @PostMapping("/autenticar")
    public String autenticar(@RequestParam("username") String username, 
                             @RequestParam("password") String password, 
                             HttpSession sesion, 
                             Model modelo) {
        
        Usuario usuario = usuarioServicio.validarUsuario(username, password);
        
        if (usuario != null) {
           
            sesion.setAttribute("usuarioSesion", usuario);
            return "redirect:/login/principal";
        } else {
            modelo.addAttribute("error", "Credenciales incorrectas. Inténtelo de nuevo.");
            return "Login";
        }
    }

    // PÁGINA PRINCIPAL
    @GetMapping("/principal")
    public String mostrarPrincipal(HttpSession sesion) {
        if (sesion.getAttribute("usuarioSesion") == null) {
            return "redirect:/login";
        }
        return "Principal";
    }

    // CERRAR SESION
    @GetMapping("/cerrar")
    public String cerrarSesion(HttpSession sesion) {
        sesion.invalidate();
        return "redirect:/login";
    }
}