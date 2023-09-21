package org.fish.core.exception;


public enum ResultMsgEnum {
    SUCCESS(200, "Success"),
    ERROR(500, "Fail");

    private final Integer code;
    private final String message;

    ResultMsgEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
