package com.kranium.project.gearapi.modules.users.exceptions;

import com.kranium.project.gearapi.modules.users.domain.User;
import lombok.Getter;

@Getter
public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(User user, String message){
        super("User: "+user.getUsername()+" Not found error: "+message);
    }
}

