package com.spring.devspring.exception;

import org.springframework.http.HttpStatus;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {
    private int status;
    private HttpStatus statusMsg;
    private String message;

    public ErrorResponse(ErrorCode errorCode){
        this.status = errorCode.getStatus();
        this.statusMsg = errorCode.getStatusMsg();
        this.message = errorCode.getMessage();
    }

}
