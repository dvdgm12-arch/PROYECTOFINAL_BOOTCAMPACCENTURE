package com.hotel.excepciones;

public class ReservaConflictiva extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ReservaConflictiva(String mensaje) {
        super(mensaje);
    }
}
