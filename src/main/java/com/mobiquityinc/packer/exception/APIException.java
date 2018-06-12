package com.mobiquityinc.packer.exception;

/**
 * General Runtime Exception for the app
 */
public class APIException extends RuntimeException {

    private final ErrorCode errorCode;

    public APIException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public APIException(Throwable throwable, ErrorCode errorCode) {
        super(errorCode.getMessage(), throwable);
        this.errorCode = errorCode;
    }
}
