package net.swmaestro.portal.common.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {
    public NotFoundException(String message) {
        super("404", message, HttpStatus.NOT_FOUND);
    }
}
