package org.fish.product.exception;

import lombok.extern.slf4j.Slf4j;
import org.fish.core.exception.ResultMsgEnum;
import org.fish.core.http.CommonResult;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(Exception.class)
    public CommonResult<?> error(Exception e) {
        log.error("Error ", e);
        return CommonResult.fail(ResultMsgEnum.ERROR.getCode(), "Server Error!");
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public CommonResult<?> handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        log.error("Error ", e);
        final String message = "Unsupported HTTP request method " + e.getMethod();
        return CommonResult.fail(ResultMsgEnum.ERROR.getCode(), message);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public CommonResult<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        log.error("Error ", e);
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> fileErrors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(fieldError -> fileErrors.put(fieldError.getField(), fieldError.getDefaultMessage()));
        return CommonResult.fail(ResultMsgEnum.ERROR.getCode(), "Request parameter error!", fileErrors);
    }
}
