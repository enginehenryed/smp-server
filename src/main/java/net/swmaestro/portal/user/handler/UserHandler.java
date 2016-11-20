package net.swmaestro.portal.user.handler;


import net.swmaestro.portal.user.vo.User;
import net.swmaestro.portal.user.vo.UserResult;

import java.util.List;


public interface UserHandler {

	UserResult selectUser(int userId) throws Exception;

	User selectUserByEmail(String userEmail) throws Exception;

	boolean checkIsAdmin(int userId) throws Exception;

	boolean checkIsMentor(int userId) throws Exception;

	List<UserResult> searchUsers(int callerId, String query) throws Exception;

}
