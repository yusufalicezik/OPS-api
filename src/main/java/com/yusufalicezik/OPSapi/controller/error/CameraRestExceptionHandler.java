package com.yusufalicezik.OPSapi.controller.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CameraRestExceptionHandler {


    @ExceptionHandler
    public ResponseEntity<CameraErrorResponse> handleException(CameraAlreadyExistError exc) {

        CameraErrorResponse error = new CameraErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exc.getErrorMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }


    // catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<CameraErrorResponse> handleException(Exception exc) {
        CameraErrorResponse error = new CameraErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exc.getMessage(),
                System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}