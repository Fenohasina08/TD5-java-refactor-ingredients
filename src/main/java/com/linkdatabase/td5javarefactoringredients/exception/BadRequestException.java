package com.linkdatabase.td5javarefactoringredients.exception;

public class BadRequestException extends RuntimeException {
    public BadRequestException(String message) {
        super(message);
    }
}