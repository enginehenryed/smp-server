package net.swmaestro.portal.user.dao;


import net.swmaestro.portal.common.dao.AbstractDAO;
import net.swmaestro.portal.user.vo.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository("userDAO")
public class UserDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public User selectUser(Map<String, Object> map) throws Exception{
		return (User) selectOne("user.selectUser", map);
	}

	@SuppressWarnings("unchecked")
	public User selectUserByEmail(Map<String, Object> map) throws Exception{
		return (User) selectOne("user.selectUserByEmail", map);
	}

	@SuppressWarnings("unchecked")
	public List<User> selectAllUsers(Map<String, Object> map) throws Exception{
		return (List<User>) selectList("user.selectAllUsers", map);
	}

	@SuppressWarnings("unchecked")
	public int insertUser(Map<String, Object> map) throws Exception {
		return (int) insert("user.insertUser", map);
	}

	@SuppressWarnings("unchecked")
	public int countUserGroupsByGroupCode(Map<String, Object> map) throws Exception {
		return (int) selectOne("user.countUserGroupsByGroupCode", map);
	}

	public void updateUser(Map<String, Object> map) throws Exception {
		update("user.updateUser", map);
	}

	public void removeUser(Map<String, Object> map) throws Exception {
		update("user.removeUser", map);
	}
}
