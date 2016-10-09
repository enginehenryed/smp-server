package net.swmaestro.portal.auth.service;


import net.swmaestro.portal.auth.TokenUtil;
import net.swmaestro.portal.auth.dao.AuthDAO;
import net.swmaestro.portal.sample.dao.SampleDAO;
import net.swmaestro.portal.user.dao.UserDAO;
import net.swmaestro.portal.user.vo.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("authService")
public class AuthServiceImpl implements AuthService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="userDAO")
	private UserDAO userDAO;

	@Override
	public User getUserByEmail(Map<String, Object> map) throws Exception {
		return userDAO.selectUser(map);
	}

	@Override
	public String getToken(String email, String password) {
		User user = null;
		try {
			user = userDAO.selectUserByEmail(email);
		} catch (Exception e) {
			e.printStackTrace();
		} finally { }

		if (user == null) {
			// TODO: Impl - User not exists.
			return null;
		}

		// TODO: Check password is valid.

		String token = TokenUtil.generate(user.getUserId());

		return token;
	}
}
