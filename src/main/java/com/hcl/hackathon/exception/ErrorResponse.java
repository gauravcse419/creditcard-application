package com.hcl.hackathon.exception;
import lombok.Data;

@Data
public class ErrorResponse {
    private int errorCode;
    private String errorMessage;

    public ErrorResponse(int errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}