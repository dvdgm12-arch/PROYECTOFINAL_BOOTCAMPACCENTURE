package com.hotel.controladores;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.entidades.Huesped;
import com.hotel.servicios.HuespedServicio;

@Controller
@RequestMapping("/huespedes")
public class HuespedControlador {

    @Autowired
    private HuespedServicio huespedServicio;
    
    // LISTADO GENERAL Y FILTROS BÚSQUEDA
    @GetMapping
    public String listarHuespedes(
            @RequestParam(value = "nombre", required = false) String nombre,
            @RequestParam(value = "dni", required = false) String dni,
            Model modelo) {
        
        List<Huesped> lista;
        
        // FILTRAR
        if ((nombre != null && !nombre.isEmpty()) || (dni != null && !dni.isEmpty())) {
            lista = huespedServicio.buscar(nombre, dni);
        } else {
            lista = huespedServicio.obtenerTodas();
        }
        
        modelo.addAttribute("listaHuespedes", lista);
        
        modelo.addAttribute("nombreBusqueda", nombre);
        modelo.addAttribute("dniBusqueda", dni);
        
        /*java.util.Map<String, String> usuarioFalso = new java.util.HashMap<>();
        usuarioFalso.put("nombre", "Liante de Pruebas");
        usuarioFalso.put("rol", "recepcionista"); 
        modelo.addAttribute("usuarioSesion", usuarioFalso); */
        
        return "Huespedes";
    }
    
    // DETALLE DEL HUÉSPED
    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") Integer id, Model modelo) {
        Huesped h = huespedServicio.obtenerPorId(id);
        modelo.addAttribute("huesped", h);
        
        /*java.util.Map<String, String> usuarioFalso = new java.util.HashMap<>();
        usuarioFalso.put("rol", "recepcionista");
        modelo.addAttribute("usuarioSesion", usuarioFalso); */
        
        return "DetalleHuesped";
    }
    
    // FORMULARIO (ALTA)
    @GetMapping("/nuevo")
    public String mostrarFormularioAlta(Model modelo) {
        Huesped nuevoHuesped = new Huesped();
        nuevoHuesped.setId(0);
        
        modelo.addAttribute("huesped", nuevoHuesped);
        
        /*java.util.Map<String, String> usuarioFalso = new java.util.HashMap<>();
        usuarioFalso.put("rol", "recepcionista");
        modelo.addAttribute("usuarioSesion", usuarioFalso); */
        
        return "FormularioHuesped";
    }
    
    // FORMULARIO (EDICIÓN)
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable("id") Integer id, Model modelo) {
        Huesped hExistente = huespedServicio.obtenerPorId(id);
        modelo.addAttribute("huesped", hExistente);
        
       /* java.util.Map<String, String> usuarioFalso = new java.util.HashMap<>();
        usuarioFalso.put("rol", "recepcionista");
        modelo.addAttribute("usuarioSesion", usuarioFalso); */
        
        return "FormularioHuesped";
    }
    
     // PROCESAR FORMULARIO
    @PostMapping(value = "/guardar")
    public String guardarHuesped(@ModelAttribute("huesped") Huesped elHuesped) {
        huespedServicio.guardar(elHuesped);
        return "redirect:/huespedes";
    }

    // ELIMINAR
    @GetMapping("/eliminar/{id}")
    public String eliminarHuesped(@PathVariable("id") Integer id) {
        huespedServicio.eliminar(id);
        return "redirect:/huespedes";
    }
}