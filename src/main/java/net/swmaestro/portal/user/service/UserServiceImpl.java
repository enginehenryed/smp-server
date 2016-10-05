package net.swmaestro.portal.user.service;


import net.swmaestro.portal.user.dao.UserDAO;
import net.swmaestro.portal.user.vo.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
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

}
