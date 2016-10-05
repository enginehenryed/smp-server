package net.swmaestro.portal.user.dao;


import net.swmaestro.portal.common.dao.AbstractDAO;
import net.swmaestro.portal.user.vo.User;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("userDAO")
public class UserDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public User selectUser(Map<String, Object> map) throws Exception{
		return (User) selectOne("user.selectUser", map);
	}

	@SuppressWarnings("unchecked")
	public List<User> selectAllUsers(Map<String, Object> map) throws Exception{
		return (List<User>) selectList("user.selectUser", map);
	}

}
