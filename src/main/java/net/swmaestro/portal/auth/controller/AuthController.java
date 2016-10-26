package net.swmaestro.portal.auth.controller;

import net.swmaestro.portal.auth.service.AuthService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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
    public @ResponseBody Object token(@RequestParam String email, @RequestParam String password) throws Exception {

        String token = authService.getToken(email, password);

        Map<String, String> res = new HashMap<>();
        res.put("token", token);
        return res;
    }

}
