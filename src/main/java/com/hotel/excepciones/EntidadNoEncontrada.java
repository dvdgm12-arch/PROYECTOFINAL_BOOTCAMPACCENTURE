package com.hotel.excepciones;

public class EntidadNoEncontrada extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EntidadNoEncontrada(String mensaje) {
        super(mensaje);
    }
}
