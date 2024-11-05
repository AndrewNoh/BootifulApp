package com.andrew.bootiful.global.response;

import com.andrew.bootiful.global.exception.ErrorCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Getter
@JsonInclude(JsonInclude.Include.NON_NULL) // null 필드는 JSON 출력에서 제외
public record ApiResponse<T>(ResponseStatus status, String message, T data, String error) {
    private static final String SUCCESS_MESSAGE = "Success";
    private static final String DEFAULT_ERROR_MESSAGE = "An error occurred";

    // 성공 응답 생성
    public static <T> ApiResponse<T> success(T data) {
        return new ApiResponse<>(ResponseStatus.SUCCESS, SUCCESS_MESSAGE, data, null);
    }

    // 데이터가 없는 성공 응답 생성
    public static <T> ApiResponse<T> success() {
        return success(null);
    }

    // ResponseEntity 생성 메서드
    public ResponseEntity<ApiResponse<T>> toResponseEntity(HttpStatus httpStatus) {
        return new ResponseEntity<>(this, httpStatus);
    }

    // 실패 응답 생성
    public static <T> ApiResponse<T> error(String message, String errorDetails) {
        return new ApiResponse<>(ResponseStatus.ERROR, message != null ? message : DEFAULT_ERROR_MESSAGE, null, errorDetails);
    }

    // 오류 응답에 대한 ResponseEntity 생성 메서드
    public static <T> ResponseEntity<ApiResponse<T>> errorResponse(ErrorCode errorCode, String message) {
        ApiResponse<T> response = ApiResponse.error(message, errorCode.getDescription());
        return response.toResponseEntity(errorCode.getHttpStatus());
    }
}
