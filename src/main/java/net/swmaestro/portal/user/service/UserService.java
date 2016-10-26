package net.swmaestro.portal.user.service;


import net.swmaestro.portal.user.dao.UserDAO;
import net.swmaestro.portal.user.vo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

	User selectUser(int userId) throws Exception;

	int insertUser(User user) throws Exception;

}
