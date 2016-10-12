package net.swmaestro.portal.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by junha on 2016. 10. 9..
 */
public class MissingTokenException extends AuthenticationException {

    public MissingTokenException(String message) {
        super(message);
    }
}
