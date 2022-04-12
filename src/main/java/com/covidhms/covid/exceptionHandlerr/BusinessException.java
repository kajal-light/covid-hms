package com.covidhms.covid.exceptionHandlerr;

import org.springframework.stereotype.Component;



    @Component
    public class BusinessException extends RuntimeException {

        private String message;
        private String errorCode;

        public BusinessException(String message, String errorCode) {
            super();
            this.message = message;
            this.errorCode = errorCode;
        }

        public BusinessException(){

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


