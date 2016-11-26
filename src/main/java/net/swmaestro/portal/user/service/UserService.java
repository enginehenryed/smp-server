package net.swmaestro.portal.user.service;


import net.swmaestro.portal.user.vo.User;
import net.swmaestro.portal.user.vo.UserResult;

import java.util.List;

public interface UserService {

	UserResult selectUser(Integer caller, int userId) throws Exception;

	List<UserResult> selectAllUsers(Integer caller) throws Exception;

	int insertUser(User user) throws Exception;

	void updateUser(User user) throws Exception;

    void deleteUser(Integer userId) throws Exception;
}
