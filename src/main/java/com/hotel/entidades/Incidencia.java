package com.hotel.entidades;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;


// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

@Entity
@Table(name = "incidencias")
public class Incidencia {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_incidencia")
    private Integer id;

    /** The habitacion. */
    @ManyToOne
    @JoinColumn(name = "id_habitacion")
    private Habitacion habitacion;

    /** The descripcion. */
    @Column(name = "descripcion")
    private String descripcion;

    /** The estado. */
    @Column(name = "estado")
    private String estado;

    /** The prioridad. */
    @Column(name = "prioridad")
    private String prioridad;

    /** The fecha apertura. */
    @Column(name = "fecha_apertura")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date fechaApertura;

    /** The fecha cierre. */
    @Column(name = "fecha_cierre")
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date fechaCierre;

    /** The coste reparacion. */
    @Column(name = "coste_reparacion")
    private double costeReparacion;

    /**
     * Instantiates a new incidencia.
     */
    // CONSTRUCTOR VACÍO
    public Incidencia() {
    }

    /**
     * Instantiates a new incidencia.
     *
     * @param habitacion the habitacion
     * @param descripcion the descripcion
     * @param estado the estado
     * @param prioridad the prioridad
     * @param fechaApertura the fecha apertura
     * @param fechaCierre the fecha cierre
     * @param costeReparacion the coste reparacion
     */
    // CONSTRUCTOR DE PARÁMETROS
    public Incidencia(Habitacion habitacion, String descripcion, String estado, String prioridad, 
                      Date fechaApertura, Date fechaCierre, double costeReparacion) {
        this.habitacion = habitacion;
        this.descripcion = descripcion;
        this.estado = estado;
        this.prioridad = prioridad;
        this.fechaApertura = fechaApertura;
        this.fechaCierre = fechaCierre;
        this.costeReparacion = costeReparacion;
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
     * Gets the habitacion.
     *
     * @return the habitacion
     */
    public Habitacion getHabitacion() {
        return habitacion;
    }

    /**
     * Sets the habitacion.
     *
     * @param habitacion the new habitacion
     */
    public void setHabitacion(Habitacion habitacion) {
        this.habitacion = habitacion;
    }

    /**
     * Gets the descripcion.
     *
     * @return the descripcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Sets the descripcion.
     *
     * @param descripcion the new descripcion
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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
     * Gets the prioridad.
     *
     * @return the prioridad
     */
    public String getPrioridad() {
        return prioridad;
    }

    /**
     * Sets the prioridad.
     *
     * @param prioridad the new prioridad
     */
    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * Gets the fecha apertura.
     *
     * @return the fecha apertura
     */
    public Date getFechaApertura() {
        return fechaApertura;
    }

    /**
     * Sets the fecha apertura.
     *
     * @param fechaApertura the new fecha apertura
     */
    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    /**
     * Gets the fecha cierre.
     *
     * @return the fecha cierre
     */
    public Date getFechaCierre() {
        return fechaCierre;
    }

    /**
     * Sets the fecha cierre.
     *
     * @param fechaCierre the new fecha cierre
     */
    public void setFechaCierre(Date fechaCierre) {
        this.fechaCierre = fechaCierre;
    }

    /**
     * Gets the coste reparacion.
     *
     * @return the coste reparacion
     */
    public double getCosteReparacion() {
        return costeReparacion;
    }

    /**
     * Sets the coste reparacion.
     *
     * @param costeReparacion the new coste reparacion
     */
    public void setCosteReparacion(double costeReparacion) {
        this.costeReparacion = costeReparacion;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Incidencia [id=" + id + ", habitacion=" + (habitacion != null ? habitacion.getNumero() : "null") 
                + ", estado=" + estado + ", prioridad=" + prioridad + "]";
    }
}