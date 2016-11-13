package net.swmaestro.portal.common.exception_handler;

import net.swmaestro.portal.common.exception.BadRequestException;
import net.swmaestro.portal.common.exception.BaseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by junha on 2016. 11. 13..
 */
@ControllerAdvice
public class GlobalDefaultExceptionHandler {

//    @ExceptionHandler(value=BadRequestException.class)
//    public ResponseEntity<Map<String, String>> badRequest(HttpServletRequest request, BaseException exception) throws Exception {
//        return new ResponseEntity<>(res, HttpStatus.INTERNAL_SERVER_ERROR);
//    }

    @ExceptionHandler(value=BaseException.class)
    public ResponseEntity<Map<String, String>> base(HttpServletRequest request, BaseException exception) throws Exception {
        return makeResponse(exception, exception.getResponseCode());
    }

    // Utils
    private static ResponseEntity<Map<String, String>> makeResponse(BaseException exception, HttpStatus status) {
        Map<String, String> res = new HashMap<>();
        res.put("code", exception.getCode());
        res.put("message", exception.getMessage());

        return new ResponseEntity<>(res, status);
    }
}
