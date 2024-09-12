package com.dea.PropertySphere.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    public ResourceNotFoundException (String message){
        super(message);
    }
}

//If a transaction with a given Id is not there in the db, this exception is thrown and spring boot will catch
//it and get the error msg from the exception and it'll send the error msg along with the HTTP status to the user