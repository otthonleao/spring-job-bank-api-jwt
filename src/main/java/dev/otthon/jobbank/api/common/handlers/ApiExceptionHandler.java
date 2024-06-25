package dev.otthon.jobbank.api.common.handlers;

import dev.otthon.jobbank.api.common.dtos.ErrorResponse;
import dev.otthon.jobbank.core.exceptions.ModelNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    @ResponseStatus(code = HttpStatus.NOT_FOUND)
    public ErrorResponse handleModelNotFoundException(ModelNotFoundException exception) {
        return ErrorResponse.builder()
                .message(exception.getLocalizedMessage())
                .build();
    }
}
