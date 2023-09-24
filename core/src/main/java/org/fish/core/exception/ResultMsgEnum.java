package org.fish.core.exception;


import lombok.Getter;

@Getter
public enum ResultMsgEnum {
    SUCCESS("Common.Code.Success", "Success"),
    ERROR("Common.Code.Error", "Fail");

    private final String code;
    private final String message;

    ResultMsgEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

}
