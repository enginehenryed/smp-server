package net.swmaestro.portal.filter;

import net.swmaestro.portal.auth.JWTAuthentication;
import net.swmaestro.portal.exception.MissingTokenException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by junha on 2016. 10. 9..
 */
public class JWTAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

    private static final Logger logger = LoggerFactory.getLogger(JWTAuthenticationFilter.class);

    public JWTAuthenticationFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        logger.debug("JWTAuthenticationFilter: BEFORE: attemptAuthentication()\n");

        String authorizationHeader = request.getHeader("Authorization");

        if (authorizationHeader == null) {
            throw new MissingTokenException("Authorization header required.");
        }
        if (!authorizationHeader.startsWith("Bearer ")) {
            throw new MissingTokenException("Authorization header needs Bearer token.");
        }

        String token = authorizationHeader.substring(7);

        return getAuthenticationManager().authenticate(new JWTAuthentication(token));
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        logger.debug("JWTAuthenticationFilter: BEFORE: successfulAuthentication()\n\t%s\n", authResult);
        super.successfulAuthentication(request, response, chain, authResult);

        // Continue chaining if Authentication succeed.
        chain.doFilter(request, response);
        logger.debug("JWTAuthenticationFilter: AFTER: successfulAuthentication()\n\t%s\n", authResult);
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        logger.debug("JWTAuthenticationFilter: BEFORE: doFilter()\n");
        super.doFilter(req, res, chain);
        logger.debug("JWTAuthenticationFilter: AFTER: doFilter()\n");
    }
}
