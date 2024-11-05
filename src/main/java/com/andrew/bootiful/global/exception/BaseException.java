package com.andrew.bootiful.global.exception;

import lombok.Getter;

@Getter
public abstract class BaseException extends RuntimeException {
    private final ErrorCode errorCode;

    public BaseException(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public BaseException(String message) {
        this(message, ErrorCode.UNEXPECTED_ERROR);
    }
}
