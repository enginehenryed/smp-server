package net.swmaestro.portal.user.service;


import net.swmaestro.portal.user.vo.User;

import java.util.List;

public interface UserService {

	User selectUser(int userId) throws Exception;

	List<User> selectAllUsers() throws Exception;

	int insertUser(User user) throws Exception;

	void updateUser(User user) throws Exception;
}
