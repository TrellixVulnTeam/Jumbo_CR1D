package com.jcastillo.jumbo.sandbox.locator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BadRequestHandler {
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public BadRequestResponse processValidationError(BadRequestException ex) {
        BadRequestResponse badResponse = new BadRequestResponse();
        badResponse.setErrorCode(ex.getErrorCode().getErrorCode());
        badResponse.setErrorMessage(ex.getErrorCode().getMsg());
        return badResponse;
    }

}
