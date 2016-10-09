package net.swmaestro.portal.auth;

import com.auth0.jwt.JWTExpiredException;
import com.auth0.jwt.JWTSigner;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.JWTVerifyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SignatureException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by junha on 2016. 10. 8..
 */
public class TokenUtil {
    final static String issuer = "https://api.swmaestro.net";

    private static String secret;

    final static long EXPIRATION = 60L * 60L * 24L * 60L; // expires claim. In this case the token expires in 60 days


    public static String generate(int userId) {
        final long iat = System.currentTimeMillis() / 1000L; // issued at claim
        final long exp = iat + EXPIRATION;

        final JWTSigner signer = new JWTSigner(secret);
        final HashMap<String, Object> claims = new HashMap<>();
        claims.put("user_id", userId);
        claims.put("iss", issuer);
        claims.put("exp", exp);
        claims.put("iat", iat);

        return signer.sign(claims);
    }

    /**
     * Verify token and returns `user_id`.
     * @param jwt JWT Token
     * @return User ID of token.
     * @throws JWTVerifyException
     * @throws Exception
     */
    public static int parse(String jwt) throws JWTVerifyException, SignatureException, NoSuchAlgorithmException, InvalidKeyException, IOException, IllegalStateException {
        final JWTVerifier verifier = new JWTVerifier(secret);

        final Map<String, Object> claims = verifier.verify(jwt);
        return (int)claims.get("user_id");
    }

    public static void setSecret(String secret) {
        TokenUtil.secret = secret;
    }
}
