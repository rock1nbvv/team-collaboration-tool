package com.strikersoft.internal.teamcollaborationtool.app.controller;

import com.strikersoft.internal.teamcollaborationtool.app.data.response.ResponseWrapper;
import com.strikersoft.internal.teamcollaborationtool.app.exception.AbstractHttpException;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Mono;

/**
 * @author Vlad Baklaiev
 */
@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(AbstractHttpException.class)
    @ResponseBody
    public Mono<ResponseWrapper> handleHttpException(AbstractHttpException ex, ServerHttpRequest request) {
        return Mono.just(new ResponseWrapper<>(String.valueOf(ex.getHttpStatus().value()), ex.getMessage()));
    }
}
