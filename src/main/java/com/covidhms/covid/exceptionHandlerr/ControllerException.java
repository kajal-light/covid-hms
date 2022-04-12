package com.covidhms.covid.exceptionHandlerr;

import org.springframework.stereotype.Component;

@Component
public class ControllerException extends RuntimeException {


    private String message;
    private String errorCode;

    public ControllerException(String message, String errorCode) {
        super();
        this.message = message;
        this.errorCode = errorCode;
    }

    public ControllerException(){

    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}


