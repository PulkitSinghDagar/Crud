package com.example.projectapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class StudentAlreadyExistException extends RuntimeException{
    public StudentAlreadyExistException(String message){
        super(message);
    }
}
