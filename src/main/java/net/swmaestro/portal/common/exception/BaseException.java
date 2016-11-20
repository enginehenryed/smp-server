package net.swmaestro.portal.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by junha on 2016. 11. 13..
 */
public class BaseException extends RuntimeException {
    private final HttpStatus responseCode;

    private final String code;
    private String message;

    BaseException() {
        this.code = "999";
        this.message = "";
        this.responseCode = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    BaseException(String code, String message, HttpStatus responseCode) {
        this.code = code;
        this.message = message;
        this.responseCode = responseCode;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getResponseCode() {
        return responseCode;
    }
}
