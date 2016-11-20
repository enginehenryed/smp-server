package net.swmaestro.portal.auth.controller;

import net.swmaestro.portal.auth.exception.InvalidAuthorizationException;
import net.swmaestro.portal.auth.exception.MissingAuthorizationException;
import net.swmaestro.portal.auth.exception.MissingTokenException;
import net.swmaestro.portal.auth.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.nio.charset.Charset;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by junha on 2016. 10. 1..
 */
@Controller
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Resource(name="authService")
    private AuthService authService;

    @RequestMapping(value="/auth/token")
    public @ResponseBody Object token(@RequestHeader(value="Authorization") String authorizationHeader) throws Exception {

        if (authorizationHeader == null) {
            throw new MissingAuthorizationException("Basic Authorization header required.");
        }
        if (!authorizationHeader.startsWith("Basic ")) {
            throw new InvalidAuthorizationException("Basic Authorization header needs Basic token.");
        }

        String base64Credentials = authorizationHeader.substring("Basic".length()).trim();
        String credentials = new String(Base64.getDecoder().decode(base64Credentials),
                Charset.forName("UTF-8"));
        // credentials = username:password

        final String[] values = credentials.split(":",2);
        String email = values[0];
        String password = values[1];

        String token = authService.getToken(email, password);

        Map<String, String> res = new HashMap<>();
        res.put("token", token);
        return res;
    }

}
