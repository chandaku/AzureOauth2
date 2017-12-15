package com.spring.azure.oauth2.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class UserAccessFailedException extends RuntimeException {

    public UserAccessFailedException(String message){
        super(message);
    }
}
