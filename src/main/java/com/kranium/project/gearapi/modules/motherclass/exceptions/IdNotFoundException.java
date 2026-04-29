package com.kranium.project.gearapi.modules.motherclass.exceptions;

import java.util.UUID;

public class IdNotFoundException extends RuntimeException {
    private final UUID uuid;
    private final String message;
    public IdNotFoundException(String message, UUID uuid){
        this.message=message;
        this.uuid=uuid;
    }
}
