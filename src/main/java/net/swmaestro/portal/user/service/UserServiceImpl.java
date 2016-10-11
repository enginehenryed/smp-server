package net.swmaestro.portal.user.service;


import net.swmaestro.portal.user.dao.UserDAO;
import net.swmaestro.portal.user.vo.User;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="userDAO")
	private UserDAO userDAO;

	@Override
	public User selectUser(Map<String, Object> map) throws Exception {
		return userDAO.selectUser(map);
	}

	@Override
	public User insertUser(String email, String password, String name) throws Exception {
		// TODO: email UNIQUE Check

		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encryptedPassword = encoder.encode(password);

		Map<String, Object> map = new HashMap<>();
		map.put("userEmail", email);
		map.put("userPassword", encryptedPassword);
		map.put("userName", name);

		return userDAO.insertUser(map);
	}
}
