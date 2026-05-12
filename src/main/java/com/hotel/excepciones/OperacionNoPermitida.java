package com.hotel.excepciones;

public class OperacionNoPermitida extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public OperacionNoPermitida(String mensaje) {
        super(mensaje);
    }
}
