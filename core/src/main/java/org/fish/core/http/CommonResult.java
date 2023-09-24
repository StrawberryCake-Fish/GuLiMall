package org.fish.core.http;

import org.fish.core.exception.ResultMsgEnum;

import java.io.Serial;
import java.io.Serializable;

public class CommonResult<T> extends BaseResult<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = -7268040542410707954L;

    public CommonResult() {
    }

    public CommonResult(String message) {
        this.setMessage(message);
    }

    public CommonResult(String code, String message) {
        this.setCode(code);
        this.setMessage(message);
    }

    public CommonResult(String message, T data) {
        this.setMessage(message);
        this.setResult(data);
    }

    public static <T> CommonResult<T> ok() {
        return ok(ResultMsgEnum.SUCCESS.getCode(), ResultMsgEnum.SUCCESS.getMessage());
    }

    public static <T> CommonResult<T> ok(T data) {
        return baseCreate(ResultMsgEnum.SUCCESS.getCode(), ResultMsgEnum.SUCCESS.getMessage(), data);
    }

    public static <T> CommonResult<T> ok(String code, String msg) {
        return baseCreate(code, msg);
    }

    public static <T> CommonResult<T> ok(String code, String msg, T data) {
        return baseCreate(code, msg, data);
    }

    public static <T> CommonResult<T> fail() {
        return fail(ResultMsgEnum.ERROR.getCode(), ResultMsgEnum.ERROR.getMessage());
    }

    public static <T> CommonResult<T> fail(String code, String msg) {
        return baseCreate(code, msg);
    }

    public static <T> CommonResult<T> fail(String code, String msg, T data) {
        return baseCreate(code, msg, data);
    }

    private static <T> CommonResult<T> baseCreate(String code, String msg) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(code);
        result.setMessage(msg);
        result.setTimestamp(String.valueOf(System.currentTimeMillis()));
        return result;
    }

    private static <T> CommonResult<T> baseCreate(String code, String msg, T data) {
        CommonResult<T> result = new CommonResult<>();
        result.setCode(code);
        result.setMessage(msg);
        result.setTimestamp(String.valueOf(System.currentTimeMillis()));
        result.setResult(data);
        return result;
    }

    @Override
    public T getResult() {
        return super.getResult();
    }
}

