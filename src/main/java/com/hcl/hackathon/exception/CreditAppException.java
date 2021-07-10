package com.hcl.hackathon.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.PRECONDITION_FAILED)
@Data
public class CreditAppException extends RuntimeException {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private final int errorCode;
    private final String errorMessage;

    public CreditAppException(int errorCode, String errorMessage) {
        super();
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }
}
