package com.sanger.sprintel.error.exceptions;

public class EntityNotFoundException extends RuntimeException {
    public EntityNotFoundException() {
        super("No results can be found");
    }

    public EntityNotFoundException(String entity) {
        super("No results can be found with entity " + entity);
    }

}