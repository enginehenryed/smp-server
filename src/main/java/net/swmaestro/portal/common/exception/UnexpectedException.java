package net.swmaestro.portal.common.exception;

import org.springframework.http.HttpStatus;

public class UnexpectedException extends BaseException {
    public UnexpectedException(String message) {
        super("404", message, HttpStatus.NOT_FOUND);
    }
}
