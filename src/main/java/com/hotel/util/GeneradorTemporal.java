package com.hotel.util;

import org.apache.log4j.Logger;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

public class GeneradorTemporal {

    /** The Constant logger. */
    private static final Logger logger = Logger.getLogger(GeneradorTemporal.class);

    /**
     * The main method.
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        
        logger.info("NUEVO HASH ANA: " + Encriptador.encriptar("1234abcd"));
        logger.info("NUEVO HASH JUAN: " + Encriptador.encriptar("juan2026"));

    }
}
