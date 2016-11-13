package net.swmaestro.portal.common.exception;

import org.springframework.http.HttpStatus;

/**
 * Created by junha on 2016. 11. 13..
 */
public class BadRequestException extends BaseException {

    public BadRequestException(String message) {
        super("400", message, HttpStatus.BAD_REQUEST);
    }
}
