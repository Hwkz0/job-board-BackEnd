package com.application.jobboard.auth.exception;

public class EntityNotFoundException extends RuntimeException {

    public EntityNotFoundException(Long entityId, String entityType){
        super("Could not find" + entityType + " " + entityId);
    }

}
