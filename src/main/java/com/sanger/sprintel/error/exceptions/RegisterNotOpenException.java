package com.sanger.sprintel.error.exceptions;

public class RegisterNotOpenException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RegisterNotOpenException() {
        super("Regiter not open, first open the register");
    }

}
