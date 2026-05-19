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
@Table(name = "reservas")
public class Reserva {

    /** The id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private Integer id;

    /** The huesped. */
    @ManyToOne
    @JoinColumn(name = "id_huesped", nullable = false)
    private Huesped huesped;

    /** The habitacion. */
    @ManyToOne
    @JoinColumn(name = "id_habitacion", nullable = false)
    private Habitacion habitacion;

    /** The fecha entrada. */
    @Column(name = "fecha_entrada")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntrada;

    /** The fecha salida. */
    @Column(name = "fecha_salida")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaSalida;

    /** The num personas. */
    @Column(name = "num_personas")
    private Integer numPersonas;

    /** The metodo pago. */
    @Column(name = "metodo_pago")
    private String metodoPago;

    /** The total reserva. */
    @Column(name = "total_reserva")
    private Double totalReserva;

    /**
     * Instantiates a new reserva.
     */
    // CONSTRUCTOR VACÍO
    public Reserva() {
    }

    /**
     * Instantiates a new reserva.
     *
     * @param huesped the huesped
     * @param habitacion the habitacion
     * @param fechaEntrada the fecha entrada
     * @param fechaSalida the fecha salida
     * @param numPersonas the num personas
     * @param metodoPago the metodo pago
     * @param totalReserva the total reserva
     */
    // CONSTRUCTOR CON PARÁMETROS
    public Reserva(Huesped huesped, Habitacion habitacion, Date fechaEntrada, Date fechaSalida, 
                   Integer numPersonas, String metodoPago, Double totalReserva) {
        this.huesped = huesped;
        this.habitacion = habitacion;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
        this.numPersonas = numPersonas;
        this.metodoPago = metodoPago;
        this.totalReserva = totalReserva;
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
     * Gets the huesped.
     *
     * @return the huesped
     */
    public Huesped getHuesped() {
        return huesped;
    }

    /**
     * Sets the huesped.
     *
     * @param huesped the new huesped
     */
    public void setHuesped(Huesped huesped) {
        this.huesped = huesped;
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
     * Gets the fecha entrada.
     *
     * @return the fecha entrada
     */
    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    /**
     * Sets the fecha entrada.
     *
     * @param fechaEntrada the new fecha entrada
     */
    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    /**
     * Gets the fecha salida.
     *
     * @return the fecha salida
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Sets the fecha salida.
     *
     * @param fechaSalida the new fecha salida
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Gets the num personas.
     *
     * @return the num personas
     */
    public Integer getNumPersonas() {
        return numPersonas;
    }

    /**
     * Sets the num personas.
     *
     * @param numPersonas the new num personas
     */
    public void setNumPersonas(Integer numPersonas) {
        this.numPersonas = numPersonas;
    }

    /**
     * Gets the metodo pago.
     *
     * @return the metodo pago
     */
    public String getMetodoPago() {
        return metodoPago;
    }

    /**
     * Sets the metodo pago.
     *
     * @param metodoPago the new metodo pago
     */
    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    /**
     * Gets the total reserva.
     *
     * @return the total reserva
     */
    public Double getTotalReserva() {
        return totalReserva;
    }

    /**
     * Sets the total reserva.
     *
     * @param totalReserva the new total reserva
     */
    public void setTotalReserva(Double totalReserva) {
        this.totalReserva = totalReserva;
    }

    /**
     * To string.
     *
     * @return the string
     */
    @Override
    public String toString() {
        return "Reserva [id=" + id + ", huesped=" + (huesped != null ? huesped.getNombre() : "null") 
                + ", habitacion=" + (habitacion != null ? habitacion.getNumero() : "null") + "]";
    }
}