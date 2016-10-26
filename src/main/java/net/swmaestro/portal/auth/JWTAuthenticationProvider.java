package net.swmaestro.portal.auth;

import com.auth0.jwt.JWTExpiredException;
import com.auth0.jwt.JWTVerifyException;
import net.swmaestro.portal.auth.exception.ExpiredTokenException;
import net.swmaestro.portal.auth.exception.InvalidTokenException;
import net.swmaestro.portal.auth.exception.UnexpectedException;
import net.swmaestro.portal.user.service.UserService;
import net.swmaestro.portal.user.vo.User;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by junha on 2016. 10. 9..
 */
@Component("jwtAuthenticationProvider")
public class JWTAuthenticationProvider implements AuthenticationProvider {

    @Resource(name="userService")
    private UserService userService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        JWTAuthentication jwtAuthentication = (JWTAuthentication) authentication;

        int userId;
        try {
            userId = TokenUtil.parse(jwtAuthentication.getToken());
        } catch (JWTExpiredException e) {
            throw new ExpiredTokenException("Token is expired.");
        } catch (JWTVerifyException | IOException | SignatureException | IllegalStateException e) {
            // IOException: JWT Header error
            // SignatureException: JWT Signature verification error
            // IllegalStateException: JWT invalid
            throw new InvalidTokenException("Token is invalid.");
        } catch (NoSuchAlgorithmException | InvalidKeyException e) {
            e.printStackTrace();
            throw new UnexpectedException("Unexpected server exception");
        } finally { }

        Map<String, Object> userFilter = new HashMap<>();
        userFilter.put("user_id", userId);

        User user;
        try {
            user = userService.selectUser(userFilter);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnexpectedException("Unexpected server exception.");
        }
        if (user == null) {
            // User not exists.
            throw new InvalidTokenException("Token is invalid.");
        }

        // Authenticate Succeed
        jwtAuthentication.setUser(user);
        jwtAuthentication.setAuthenticated(true);

        return jwtAuthentication;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (JWTAuthentication.class.isAssignableFrom(authentication));
    }
}
