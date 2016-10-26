package net.swmaestro.portal.auth.service;


import net.swmaestro.portal.auth.TokenUtil;
import net.swmaestro.portal.user.dao.UserDAO;
import net.swmaestro.portal.user.handler.UserHandler;
import net.swmaestro.portal.user.vo.User;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Map;

@Service("authService")
public class AuthServiceImpl implements AuthService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="userHandler")
	private UserHandler userHandler;

	@Override
	public String getToken(String email, String password) {
		User user = null;
		try {
			user = userHandler.selectUserByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		} finally { }

		if (user == null) {
			// TODO: Impl - User not exists. (Leave)
			return null;
		}

		PasswordEncoder encoder = new BCryptPasswordEncoder();
		if (!encoder.matches(password, user.getUserPassword())) {
			// Password NOT matching.
			return null;
		}

		String token = TokenUtil.generate(user.getUserId());

		return token;
	}
}
