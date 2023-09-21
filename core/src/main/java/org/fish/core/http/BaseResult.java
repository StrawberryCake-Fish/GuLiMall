package org.fish.core.http;

import lombok.Data;

import java.io.Serializable;


@Data
public abstract class BaseResult<T> implements Serializable {
    private String version;
    private String timestamp;
    private Integer code;
    private String message;
    private T result;
    private String tracerId;

    public void setVersion(String version) {
        this.version = version;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
