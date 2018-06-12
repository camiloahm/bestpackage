package com.mobiquityinc.packer.exception;

import lombok.Getter;

/**
 * Represents possible codes and messages for the API Exception
 */
@Getter
public enum ErrorCode {

    INVALID_ARGS("Invalid arguments: you should only pass the input file path");

    String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
