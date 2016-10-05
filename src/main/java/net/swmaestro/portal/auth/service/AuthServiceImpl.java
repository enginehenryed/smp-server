package net.swmaestro.portal.auth.service;


import net.swmaestro.portal.auth.dao.AuthDAO;
import net.swmaestro.portal.sample.dao.SampleDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("authService")
public class AuthServiceImpl implements AuthService {
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="authDAO")
	private AuthDAO authDAO;

	@Override
	public List<Map<String, Object>> getUserByEmail(Map<String, Object> map) throws Exception {
		return authDAO.selectUser(map);
	}

}
