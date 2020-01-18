package com.yusufalicezik.OPSapi.controller.error;

public class CameraAlreadyExistError extends Exception {
    private String errorMessage;
    public CameraAlreadyExistError(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
