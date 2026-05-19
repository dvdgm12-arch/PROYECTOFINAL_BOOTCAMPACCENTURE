package com.hotel.entidades;

import java.io.Serializable; 
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@Entity
@Table(name = "usuarios")
public class Usuario implements Serializable { 

    
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuarios")
    private Integer id;

    /** The username. */
    @Column(name = "username", unique = true)
    private String username;

    /** The password. */
    @Column(name = "password")
    private String password;

    /** The nombre completo. */
    @Column(name = "nombre_completo")
    private String nombreCompleto;

    /** The rol. */
    @Enumerated(EnumType.STRING)
    @Column(name = "perfil")
    private PerfilUsuario rol;

    /** The ultimo login. */
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ultimo_login")
    private Date ultimoLogin;

    /**
     * The Enum PerfilUsuario.
     */
    public enum PerfilUsuario {
        
        /** The recepcionista. */
        recepcionista, 
 /** The supervisor. */
 supervisor
    }

    /**
     * Instantiates a new usuario.
     */
    // CONSTRUCTOR VACÍO
    public Usuario() {
    }

    /**
     * Instantiates a new usuario.
     *
     * @param username the username
     * @param password the password
     * @param nombreCompleto the nombre completo
     * @param rol the rol
     * @param ultimoLogin the ultimo login
     */
    // CONSTRUCTOR DE PARÁMETROS
    public Usuario(String username, String password, String nombreCompleto, PerfilUsuario rol, Date ultimoLogin) {
        this.username = username;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.rol = rol;
        this.ultimoLogin = ultimoLogin;
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
     * Gets the username.
     *
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * Sets the username.
     *
     * @param username the new username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * Gets the password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password.
     *
     * @param password the new password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Gets the nombre completo.
     *
     * @return the nombre completo
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Sets the nombre completo.
     *
     * @param nombreCompleto the new nombre completo
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Gets the rol.
     *
     * @return the rol
     */
    public PerfilUsuario getRol() {
        return rol;
    }

    /**
     * Sets the rol.
     *
     * @param rol the new rol
     */
    public void setRol(PerfilUsuario rol) {
        this.rol = rol;
    }

    /**
     * Gets the ultimo login.
     *
     * @return the ultimo login
     */
    public Date getUltimoLogin() {
        return ultimoLogin;
    }

    /**
     * Sets the ultimo login.
     *
     * @param ultimoLogin the new ultimo login
     */
    public void setUltimoLogin(Date ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Usuario [username=" + username + ", rol=" + rol + "]";
    }
}



