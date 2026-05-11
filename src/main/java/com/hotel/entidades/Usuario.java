package com.hotel.entidades;

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

@Entity
@Table(name = "usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuarios")
    private Integer id;

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Enumerated(EnumType.STRING)
    @Column(name = "perfil")
    private PerfilUsuario perfil;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "ultimo_login")
    private Date ultimoLogin;


    public enum PerfilUsuario {
        recepcionista, supervisor
    }

    // 1. CONSTRUCTOR VACÍO
    public Usuario() {
    }

    // 2. CONSTRUCTOR DE PARÁMETROS
    public Usuario(String username, String password, String nombreCompleto, PerfilUsuario perfil, Date ultimoLogin) {
        this.username = username;
        this.password = password;
        this.nombreCompleto = nombreCompleto;
        this.perfil = perfil;
        this.ultimoLogin = ultimoLogin;
    }

    // 3. GETTERS Y SETTERS
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public PerfilUsuario getPerfil() {
        return perfil;
    }

    public void setPerfil(PerfilUsuario perfil) {
        this.perfil = perfil;
    }

    public Date getUltimoLogin() {
        return ultimoLogin;
    }

    public void setUltimoLogin(Date ultimoLogin) {
        this.ultimoLogin = ultimoLogin;
    }

    @Override
    public String toString() {
        return "Usuario [username=" + username + ", perfil=" + perfil + "]";
    }
}

