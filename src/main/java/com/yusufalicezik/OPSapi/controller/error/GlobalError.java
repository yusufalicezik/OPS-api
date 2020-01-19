package com.yusufalicezik.OPSapi.controller.error;

public class GlobalError extends Exception {
    private String errorMessage;
    public GlobalError(String errorMessage){
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}