package net.swmaestro.portal.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by junha on 2016. 10. 15..
 */
@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
public class UnexpectedException extends RuntimeException {
}
