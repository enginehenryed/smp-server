package net.swmaestro.portal.auth.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by junha on 2016. 10. 9..
 */
public class InvalidTokenException extends AuthenticationException {

    public InvalidTokenException(String message) {
        super(message);
    }
}
