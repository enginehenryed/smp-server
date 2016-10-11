package net.swmaestro.portal.user.service;


import net.swmaestro.portal.user.dao.UserDAO;
import net.swmaestro.portal.user.vo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

	User selectUser(Map<String, Object> map) throws Exception;

	User insertUser(String email, String password, String name) throws Exception;

}
