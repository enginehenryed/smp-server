package net.swmaestro.portal.auth.dao;


import net.swmaestro.portal.common.dao.AbstractDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("authDAO")
public class AuthDAO extends AbstractDAO {

	@SuppressWarnings("unchecked")
	public List<Map<String, Object>> selectUser(Map<String, Object> map) throws Exception{
		return (List<Map<String, Object>>)selectList("sample.selectUser", map);
	}

}
