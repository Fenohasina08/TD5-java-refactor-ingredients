package com.linkdatabase.td5javarefactoringredients.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public String handleNotFound(NotFoundException e) {
        return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException.class)
    public String handleBadRequest(BadRequestException e) {
        return e.getMessage();
    }
}

class NotFoundException extends RuntimeException {
    public NotFoundException(String msg) { super(msg); }
}
class BadRequestException extends RuntimeException {
    public BadRequestException(String msg) { super(msg); }
}