package com.strikersoft.internal.teamcollaborationtool.app.controller;

import com.strikersoft.internal.teamcollaborationtool.app.data.response.ResponseWrapper;
import com.strikersoft.internal.teamcollaborationtool.app.exception.AbstractHttpException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Vlad Baklaiev
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(AbstractHttpException.class)
    @ResponseBody
    public ResponseWrapper handleHttpException(AbstractHttpException ex, HttpServletRequest request) {
        return new ResponseWrapper(String.valueOf(ex.getHttpStatus().value()), ex.getMessage());
    }
}
