package com.hotel.util;

import org.apache.log4j.Logger;

public class GeneradorTemporal {

    private static final Logger logger = Logger.getLogger(GeneradorTemporal.class);

    public static void main(String[] args) {
        
        logger.info("NUEVO HASH ANA: " + Encriptador.encriptar("1234abcd"));
        logger.info("NUEVO HASH JUAN: " + Encriptador.encriptar("juan2026"));

    }
}
