package com.andrew.bootiful.global.exception;

// ResourceNotFoundException 은 요청한 리소스가 존재하지 않을 경우 발생하는 예외입니다.
public class ResourceNotFoundException extends BaseException {
    public ResourceNotFoundException(String message) {
        super(message, ErrorCode.RESOURCE_NOT_FOUND);
    }
}
