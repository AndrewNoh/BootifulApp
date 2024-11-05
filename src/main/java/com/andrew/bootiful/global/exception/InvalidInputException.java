package com.andrew.bootiful.global.exception;

// InvalidInputException 은 유효하지 않은 입력이 제공된 경우 발생하는 예외입니다.
public class InvalidInputException extends BaseException {
    public InvalidInputException(String message) {
        super(message, ErrorCode.INVALID_INPUT);
    }
}