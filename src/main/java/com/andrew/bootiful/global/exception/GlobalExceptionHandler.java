package com.andrew.bootiful.global.exception;

import com.andrew.bootiful.global.response.ApiResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

// GlobalExceptionHandler는 애플리케이션 전역에서 발생하는 예외를 처리하는 클래스입니다.
@RestControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    @ExceptionHandler(BaseException.class)
    public ResponseEntity<ApiResponse<Void>> handleBaseException(BaseException ex) {
        return ApiResponse.errorResponse(ex.getErrorCode(), ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse<Void>> handleGeneralException(Exception ex) {
        log.error("Unhandled exception: {}", ex.getMessage(), ex);
        return ApiResponse.errorResponse(ErrorCode.UNEXPECTED_ERROR, "An unexpected error occurred");
    }

}
