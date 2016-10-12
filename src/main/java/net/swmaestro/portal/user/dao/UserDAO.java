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
	public User selectUserByEmail(String email) throws Exception{
		Map<String, Object> map = new HashMap<>();
		map.put("user_email", email);

		return (User) selectOne("user.selectUserByEmail", map);
	}

	@SuppressWarnings("unchecked")
	public List<User> selectAllUsers(Map<String, Object> map) throws Exception{
		return (List<User>) selectList("user.selectUser", map);
	}

}
