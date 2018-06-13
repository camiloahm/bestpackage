package com.mobiquityinc.packer.exception;

import lombok.Getter;

/**
 * Represents possible codes and messages for the API Exception
 */
@Getter
public enum ErrorCode {

    INVALID_ARGS("Invalid arguments: you should only pass the input file path"),
    INVALID_INPUT("Invalid input: the valid format is <max weight> : (<item index>, <item weight>, <price>)");

    String message;

    ErrorCode(String message) {
        this.message = message;
    }
}
