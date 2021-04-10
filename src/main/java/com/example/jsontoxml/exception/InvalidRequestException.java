package com.example.jsontoxml.exception;

public class InvalidRequestException extends NullPointerException{
    public InvalidRequestException(String errorMessage) {
        super(errorMessage);
    }
}
