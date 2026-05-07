package com.hotel.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "habitaciones")
public class Habitacion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private int id;

    @Column(name = "numero_habitacion", unique = true)
    private int numero;

    @Column(name = "tipo")
    private String tipo; 

    @Column(name = "precio_noche")
    private double precio;

    @Column(name = "estado")
    private String estado;

    @Column(name = "planta")
    private int planta;

    
    // CONSTRUCTOR VACIO
    public Habitacion() {
    }


    // CONSTRUCTOR DE PARAMETROS
    public Habitacion(int numero, String tipo, double precio, String estado, int planta) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
        this.planta = planta;
    }

   
    
    // GETTERS Y SETTERS
    public int getId() {
        return id;
    }

    
    public void setId(int id) {
        this.id = id;
    }

   
    public int getNumero() {
        return numero;
    }

    
    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    public String getTipo() {
        return tipo;
    }

    
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public double getPrecio() {
        return precio;
    }

   
    public void setPrecio(double precio) {
        this.precio = precio;
    }

  
    public String getEstado() {
        return estado;
    }

    
    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    public int getPlanta() {
        return planta;
    }

    
    public void setPlanta(int planta) {
        this.planta = planta;
    }

    
    @Override
    public String toString() {
        return "Habitacion [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", precio=" + precio + ", estado="
                + estado + ", planta=" + planta + "]";
    }
}
