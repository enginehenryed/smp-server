package net.swmaestro.portal.auth;

import net.swmaestro.portal.auth.service.AuthService;
import net.swmaestro.portal.sample.HomeController;
import net.swmaestro.portal.sample.service.SampleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by junha on 2016. 10. 1..
 */
@Controller
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Resource(name="sampleService")
    private SampleService sampleService;

    @Resource(name="authService")
    private AuthService authService;

    @RequestMapping(value="/auth/signin")
    public @ResponseBody Object singin(@RequestParam String email, @RequestParam String password) throws Exception {

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("email", email);
        params.put("password", password);

        List<Map<String,Object>> ret = authService.getUserByEmail(params);

        return ret;
    }

}
