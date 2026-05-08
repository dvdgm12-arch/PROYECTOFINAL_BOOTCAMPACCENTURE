package com.hotel.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "huespedes")
public class Huesped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_huesped")
    private Integer id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "apellidos")
    private String apellidos; 

    @Column(name = "dni_pasaporte")
    private String dniPasaporte;

    @Column(name = "email")
    private String email;

    @Column(name = "telefono")
    private String telefono;

    
    // CONSTRUCTOR VACIO
    public Huesped(){

    }


    // CONSTRUCTOR DE PARAMETROS
    public Huesped(String nombre, String apellidos, String dniPasaporte, String email, String telefono) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dniPasaporte = dniPasaporte;
        this.email = email;
        this.telefono = telefono;
    }

   
    
    // GETTERS Y SETTERS
    public Integer getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellidos() {
		return apellidos;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public String getDniPasaporte() {
		return dniPasaporte;
	}


	public void setDniPasaporte(String dniPasaporte) {
		this.dniPasaporte = dniPasaporte;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelefono() {
		return telefono;
	}


	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
 

    
    @Override
    public String toString() {
        return "Huesped [id=" + id + ", nombre=" + nombre + ", dni=" + dniPasaporte + "]";
    }


}

	