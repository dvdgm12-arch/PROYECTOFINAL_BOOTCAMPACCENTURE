package com.hotel.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 


@Entity
@Table(name = "habitaciones")
public class Habitacion {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_habitacion")
    private Integer id;

    /** The numero. */
    @Column(name = "numero_habitacion", unique = true)
    private int numero;

    /** The tipo. */
    @Column(name = "tipo")
    private String tipo; 

    /** The precio. */
    @Column(name = "precio_noche")
    private double precio;

    /** The estado. */
    @Column(name = "estado")
    private String estado;

    /** The planta. */
    @Column(name = "planta")
    private int planta;

    
    /**
     * Instantiates a new habitacion.
     */
    // CONSTRUCTOR VACIO
    public Habitacion() {
    }


    /**
     * Instantiates a new habitacion.
     *
     * @param numero the numero
     * @param tipo the tipo
     * @param precio the precio
     * @param estado the estado
     * @param planta the planta
     */
    // CONSTRUCTOR DE PARAMETROS
    public Habitacion(int numero, String tipo, double precio, String estado, int planta) {
        this.numero = numero;
        this.tipo = tipo;
        this.precio = precio;
        this.estado = estado;
        this.planta = planta;
    }

   
    
    /**
     * Gets the id.
     *
     * @return the id
     */
    // GETTERS Y SETTERS
    public Integer getId() {
        return id;
    }

    
    /**
     * Sets the id.
     *
     * @param id the new id
     */
    public void setId(Integer id) {
        this.id = id;
    }

   
    /**
     * Gets the numero.
     *
     * @return the numero
     */
    public int getNumero() {
        return numero;
    }

    
    /**
     * Sets the numero.
     *
     * @param numero the new numero
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    /**
     * Gets the tipo.
     *
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    
    /**
     * Sets the tipo.
     *
     * @param tipo the new tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    /**
     * Gets the precio.
     *
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

   
    /**
     * Sets the precio.
     *
     * @param precio the new precio
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }

  
    /**
     * Gets the estado.
     *
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    
    /**
     * Sets the estado.
     *
     * @param estado the new estado
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

   
    /**
     * Gets the planta.
     *
     * @return the planta
     */
    public int getPlanta() {
        return planta;
    }

    
    /**
     * Sets the planta.
     *
     * @param planta the new planta
     */
    public void setPlanta(int planta) {
        this.planta = planta;
    }

    
    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Habitacion [id=" + id + ", numero=" + numero + ", tipo=" + tipo + ", precio=" + precio + ", estado="
                + estado + ", planta=" + planta + "]";
    }
}
