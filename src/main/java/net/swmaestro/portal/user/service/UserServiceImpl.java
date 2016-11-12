package net.swmaestro.portal.user.service;


import net.swmaestro.portal.user.dao.UserDAO;
import net.swmaestro.portal.user.vo.User;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="userDAO")
	private UserDAO userDAO;

	@Override
	public User selectUser(int userId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		
		return userDAO.selectUser(map);
	}

    @Override
    public List<User> selectAllUsers() throws Exception {
        return userDAO.selectAllUsers(new HashMap<String, Object>());
    }

    @Override
	public int insertUser(User user) throws Exception {
		// TODO: email UNIQUE Check

		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encryptedPassword = encoder.encode(user.getUserPassword());

		Map<String, Object> map = new HashMap<>();
		map.put("userEmail", user.getUserEmail());
		map.put("userPassword", encryptedPassword);
		map.put("userName", user.getUserName());
        map.put("userGender", user.getUserGender());
        map.put("userPhone", user.getUserPhone());
        return userDAO.insertUser(map);
	}
}
