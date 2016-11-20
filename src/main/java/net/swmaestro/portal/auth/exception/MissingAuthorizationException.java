package net.swmaestro.portal.auth.exception;

import org.springframework.security.core.AuthenticationException;

public class MissingAuthorizationException extends AuthenticationException {

    public MissingAuthorizationException(String message) {
        super(message);
    }
}
