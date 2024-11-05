package com.andrew.bootiful.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    RESOURCE_NOT_FOUND(HttpStatus.NOT_FOUND, "Resource not found"),
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "Invalid input"),
    UNEXPECTED_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "An unexpected error occurred");

    private final HttpStatus httpStatus;
    private final String description;

    ErrorCode(HttpStatus httpStatus, String description) {
        this.httpStatus = httpStatus;
        this.description = description;
    }
}
