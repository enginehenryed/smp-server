package net.swmaestro.portal.user.handler;


import net.swmaestro.portal.user.dao.UserDAO;
import net.swmaestro.portal.user.utils.UserUtils;
import net.swmaestro.portal.user.vo.User;
import net.swmaestro.portal.user.vo.UserResult;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userHandler")
public class UserHandlerImpl implements UserHandler {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="userDAO")
	private UserDAO userDAO;

    @Override
    public UserResult selectUser(int userId) throws Exception {
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

	@Override
	public boolean checkIsAdmin(int userId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("groupCode", "2");

		return userDAO.countUserGroupsByGroupCode(map) > 0;
	}

	@Override
	public boolean checkIsMentor(int userId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("userId", userId);
		map.put("groupCode", "1");

		return userDAO.countUserGroupsByGroupCode(map) > 0;
	}

	@Override
	public List<UserResult> searchUsers(int callerId, String query) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("query", query);

		List<UserResult> userResultList =  userDAO.searchUsers(map);

		if (!checkIsAdmin(callerId)) {
			userResultList.forEach(UserUtils::makeUserResultSafe);
		}

		return userResultList;
	}

}
