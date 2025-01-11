package com.spring.devspring.config;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Object> handleCustomException(CustomException ex) {
        ErrorCode errorCode = ex.getErrorCode();
        return new ResponseEntity<>(
                new ApiError(errorCode.getCode(), errorCode.getMessage()), 
                errorCode.getHttpStatus()
        );
    }

    // 기타 예외 처리기 추가 가능
}