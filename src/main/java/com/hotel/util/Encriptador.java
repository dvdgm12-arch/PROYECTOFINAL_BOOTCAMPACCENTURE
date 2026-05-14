package com.hotel.util;

import org.mindrot.jbcrypt.BCrypt;

public class Encriptador {

    // HASH PARA GUARDAR EN BBDD
    public static String encriptar(String passwordPlano) {
        return BCrypt.hashpw(passwordPlano, BCrypt.gensalt());
    }

    // COMPARADOR TEXTO PLANO CON HASH
    public static boolean verificar(String passwordPlano, String passwordHaseado) {
        try {
            return BCrypt.checkpw(passwordPlano, passwordHaseado);
        } catch (Exception e) {
            return false;
        }
    }
}