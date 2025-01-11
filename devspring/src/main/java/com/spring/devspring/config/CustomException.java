package com.spring.devspring.config;

public class CustomException extends RuntimeException {
	
	private static final long serialVersionUID = 1440328210932079933L;
	
	private final ErrorCode errorCode;

    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}