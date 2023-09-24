package org.fish.core.http;

import lombok.Data;
import org.slf4j.MDC;

import java.io.Serializable;


@Data
public abstract class BaseResult<T> implements Serializable {
    private final String version = this.getClass().getPackage().getImplementationVersion();
    private String timestamp;
    private String code;
    private String message;
    private T result;
    private final String tracerId = MDC.get("traceId");
}
