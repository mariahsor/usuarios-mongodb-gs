package com.gruposalinas.usuarios_mongodb.util;

/**
 * AppMessages
 */
public class AppMessages {

    private AppMessages() {
        throw new IllegalStateException("This utility class cannot be instantiated: AppMessages");
    }

    public static final String CLIENT_ERROR = "CLIENT_ERROR";
    public static final String ERROR = "SERVER_ERROR";
    public static final String UNAUTHORISED_MESSAGE = "Usted no está autorizado para acceder este recurso.";
}
