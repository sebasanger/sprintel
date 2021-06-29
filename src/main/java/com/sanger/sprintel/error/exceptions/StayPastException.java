package com.sanger.sprintel.error.exceptions;

public class StayPastException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public StayPastException() {
        super("The date of creation cannot be in the past");
    }

}
