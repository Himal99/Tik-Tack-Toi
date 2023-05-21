package com.custom.orm.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author Himal Rai on 5/19/2023
 * Sb Solutions Nepal pvt.ltd
 * Project customOrm.
 */

@ControllerAdvice
public class SbGlobalExceptionHandler {


    @ExceptionHandler(SbDbServiceValidationException.class)
    public ResponseEntity<?> serviceValidationException(SbDbServiceValidationException ex){

        //TODO: something
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
