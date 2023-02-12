package com.strikersoft.internal.teamcollaborationtool.app.exception;


import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Vlad Baklaiev
 */

@Getter
public abstract class AbstractHttpException extends RuntimeException {
    private static String standardMessage = "Execution error appeared!";

    private HttpStatus httpStatus;

    public AbstractHttpException(HttpStatus httpStatus, String message) {
        super(message);
        this.httpStatus = httpStatus;
    }

    public AbstractHttpException(HttpStatus httpStatus, String message, Throwable cause) {
        super(message, cause);
        this.httpStatus = httpStatus;
    }
}
