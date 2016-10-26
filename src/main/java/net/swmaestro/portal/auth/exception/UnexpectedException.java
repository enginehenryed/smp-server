package net.swmaestro.portal.auth.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by junha on 2016. 10. 9..
 */
public class UnexpectedException extends AuthenticationException {

    public UnexpectedException(String message) {
        super(message);
    }
}
