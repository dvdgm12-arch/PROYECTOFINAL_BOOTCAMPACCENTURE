package com.hotel.util;

import org.mindrot.jbcrypt.BCrypt;

// TODO: Auto-generated Javadoc
/**
 * *.
 *
 * @author Lidia Sandá López & David García Moreno
 * @version 1.0 VERSIÓN GOLD - 19/05/2026
 */
 

public class Encriptador {

    /**
     * Encriptar.
     *
     * @param passwordPlano the password plano
     * @return the string
     */
    // HASH PARA GUARDAR EN BBDD
    public static String encriptar(String passwordPlano) {
        return BCrypt.hashpw(passwordPlano, BCrypt.gensalt());
    }

    /**
     * Verificar.
     *
     * @param passwordPlano the password plano
     * @param passwordHaseado the password haseado
     * @return true, if successful
     */
    // COMPARADOR TEXTO PLANO CON HASH
    public static boolean verificar(String passwordPlano, String passwordHaseado) {
        try {
            return BCrypt.checkpw(passwordPlano, passwordHaseado);
        } catch (Exception e) {
            return false;
        }
    }
}