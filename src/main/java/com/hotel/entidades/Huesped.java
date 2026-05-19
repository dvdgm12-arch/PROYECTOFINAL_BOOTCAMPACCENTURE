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
@Table(name = "huespedes")
public class Huesped {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_huesped")
    private Integer id;

    /** The nombre. */
    @Column(name = "nombre")
    private String nombre;

    /** The apellidos. */
    @Column(name = "apellidos")
    private String apellidos; 

    /** The dni pasaporte. */
    @Column(name = "dni_pasaporte")
    private String dniPasaporte;

    /** The email. */
    @Column(name = "email")
    private String email;

    /** The telefono. */
    @Column(name = "telefono")
    private String telefono;

    
    /**
     * Instantiates a new huesped.
     */
    // CONSTRUCTOR VACIO
    public Huesped(){

    }


    /**
     * Instantiates a new huesped.
     *
     * @param nombre the nombre
     * @param apellidos the apellidos
     * @param dniPasaporte the dni pasaporte
     * @param email the email
     * @param telefono the telefono
     */
    // CONSTRUCTOR DE PARAMETROS
    public Huesped(String nombre, String apellidos, String dniPasaporte, String email, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dniPasaporte = dniPasaporte;
        this.email = email;
        this.telefono = telefono;
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
	 * Gets the nombre.
	 *
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}


	/**
	 * Sets the nombre.
	 *
	 * @param nombre the new nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * Gets the apellidos.
	 *
	 * @return the apellidos
	 */
	public String getApellidos() {
		return apellidos;
	}


	/**
	 * Sets the apellidos.
	 *
	 * @param apellidos the new apellidos
	 */
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	/**
	 * Gets the dni pasaporte.
	 *
	 * @return the dni pasaporte
	 */
	public String getDniPasaporte() {
		return dniPasaporte;
	}


	/**
	 * Sets the dni pasaporte.
	 *
	 * @param dniPasaporte the new dni pasaporte
	 */
	public void setDniPasaporte(String dniPasaporte) {
		this.dniPasaporte = dniPasaporte;
	}


	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * Sets the email.
	 *
	 * @param email the new email
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * Gets the telefono.
	 *
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}


	/**
	 * Sets the telefono.
	 *
	 * @param telefono the new telefono
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
 

    
    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Huesped [id=" + id + ", nombre=" + nombre + ", dni=" + dniPasaporte + "]";
    }


}

	