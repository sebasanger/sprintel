package com.sanger.sprintel.error.exceptions;

public class DateInvalidToCheckIn extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DateInvalidToCheckIn() {
        super("Date invalid to set check in");
    }

}
