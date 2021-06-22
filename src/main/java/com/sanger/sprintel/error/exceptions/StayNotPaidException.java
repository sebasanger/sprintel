package com.sanger.sprintel.error.exceptions;

public class StayNotPaidException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public StayNotPaidException() {
        super("Stay not paid");
    }

}
