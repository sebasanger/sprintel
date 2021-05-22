package com.sanger.sprintel.error.exceptions;

public class RegisterNotClosedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public RegisterNotClosedException() {
        super("Register is open, close first");
    }

}
