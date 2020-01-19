package com.yusufalicezik.OPSapi.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

    //MARK: - CAMERA-PARK

    @ExceptionHandler
    public ResponseEntity<GlobalErrorResponse> handleException(GlobalError exc) {

        GlobalErrorResponse error = new GlobalErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getErrorMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    // catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<GlobalErrorResponse> handleException(Exception exc) {
        GlobalErrorResponse error = new GlobalErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }


    //MARK: - USER


}