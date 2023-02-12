package com.strikersoft.internal.teamcollaborationtool.app.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * @author Vlad Baklaiev
 */
public class NotFoundException extends AbstractHttpException {
    @Getter
    private Class classType;
    @Getter
    private Object id;

    public NotFoundException(String message, Class classType, Object id) {
        super(HttpStatus.NOT_FOUND, message);
        this.classType = classType;
        this.id = id;
    }
}
