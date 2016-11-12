package net.swmaestro.portal.user.handler;


import net.swmaestro.portal.user.vo.User;


public interface UserHandler {

	User selectUser(int userId) throws Exception;

	User selectUserByEmail(String userEmail) throws Exception;

	boolean checkIsAdmin(int userId) throws Exception;

	boolean checkIsMentor(int userId) throws Exception;

}
