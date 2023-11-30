package com.example.topten.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DataInvalidException extends RuntimeException{
    public DataInvalidException(String message) {
        super(message);
    }
}
