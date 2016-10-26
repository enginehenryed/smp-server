package net.swmaestro.portal.user.handler;


import net.swmaestro.portal.user.dao.UserDAO;
import net.swmaestro.portal.user.vo.User;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("userHandler")
public class UserHandlerImpl implements UserHandler {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="userDAO")
	private UserDAO userDAO;

    @Override
    public User selectUser(int userId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);

        return userDAO.selectUser(map);
    }

    @Override
	public User selectUserByEmail(String userEmail) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userEmail", userEmail);
		
		return userDAO.selectUserByEmail(map);
	}

}
