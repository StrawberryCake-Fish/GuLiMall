package org.fish.core.exception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomException extends RuntimeException {
    public CustomException(String msg) {
        super(msg);
    }
}
