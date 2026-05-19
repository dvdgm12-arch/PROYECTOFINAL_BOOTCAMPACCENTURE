package com.hotel.excepciones;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

public class EntidadNoEncontrada extends RuntimeException {
    
    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/**
	 * Instantiates a new entidad no encontrada.
	 *
	 * @param mensaje the mensaje
	 */
	public EntidadNoEncontrada(String mensaje) {
        super(mensaje);
    }
}
