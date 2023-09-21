package org.fish.core.exception;


import lombok.Getter;

@Getter
public enum ResultMsgEnum {
    SUCCESS(200, "Success"),
    ERROR(500, "Fail");

    private final Integer code;
    private final String message;

    ResultMsgEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

}
