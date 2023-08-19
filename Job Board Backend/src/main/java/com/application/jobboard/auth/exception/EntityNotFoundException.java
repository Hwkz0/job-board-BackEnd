package com.application.jobboard.auth.exception;

public class EntityNotFoundException extends RuntimeException {

    /*
        * This is the EntityNotFoundException class.
        * This class is used to handle the EntityNotFoundException.
        * It returns a message saying that the entity was not found.
     */



    public EntityNotFoundException(Long entityId, String entityType){
        super("Could not find" + entityType + " " + entityId);
    }

}
