package net.swmaestro.portal.auth.exception;

import org.springframework.security.core.AuthenticationException;

/**
 * Created by dbgsprw on 2016. 11. 20..
 */
public class InvalidAuthorizationException extends AuthenticationException {

    public InvalidAuthorizationException(String message) {
        super(message);
    }
}
