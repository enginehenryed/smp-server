package net.swmaestro.portal.user.service;


import net.swmaestro.portal.common.exception.BadRequestException;
import net.swmaestro.portal.common.util.EmailValidator;
import net.swmaestro.portal.user.dao.UserDAO;
import net.swmaestro.portal.user.vo.Group;
import net.swmaestro.portal.user.vo.User;
import org.apache.log4j.Logger;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements UserService {
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
    public List<User> selectAllUsers() throws Exception {
        return userDAO.selectAllUsers(new HashMap<>());
    }

    @Override
	public int insertUser(User user) throws Exception {
        Map<String, Object> emailCheckMap = new HashMap<>();
        emailCheckMap.put("userEmail", user.getUserEmail());
        if (userDAO.countUserByEmail(emailCheckMap) > 0) {
            throw new BadRequestException("Email already exists");
        }

        if (!EmailValidator.isValid(user.getUserEmail())) {
            throw new BadRequestException("Email is not valid");
        }

		PasswordEncoder encoder = new BCryptPasswordEncoder();
		String encryptedPassword = encoder.encode(user.getUserPassword());

		Map<String, Object> map = new HashMap<>();
		map.put("userEmail", user.getUserEmail());
		map.put("userPassword", encryptedPassword);
		map.put("userName", user.getUserName());
        map.put("userGender", user.getUserGender());
        map.put("userPhone", user.getUserPhone());
        return userDAO.insertUser(map);
	}

    @Override
    public void updateUser(User user) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", user.getUserId());

        if (user.getUserName() != null) {
            map.put("userName", user.getUserName());
        }
        if (user.getUserPassword() != null) {
            PasswordEncoder encoder = new BCryptPasswordEncoder();
            String encryptedPassword = encoder.encode(user.getUserPassword());
            map.put("userPassword", encryptedPassword);
        }
        if (user.getUserPhone() != null) {
            map.put("userPhone", user.getUserPhone());
        }
        if (user.getUserGender() != null) {
            map.put("userGender", user.getUserGender());
        }

        List<Group> groups = user.getUserGroups();
        if (groups != null) {
            Map<String, Object> deleteGroupsMap = new HashMap<>();
            deleteGroupsMap.put("userId", user.getUserId());
            userDAO.deleteGroupsByUser(deleteGroupsMap);

            List<Map<String, Object>> groupMapList = new ArrayList<>();
            for (Group group : groups) {
                Map<String, Object> groupMap = new HashMap<>();
                groupMap.put("userId", user.getUserId());
                groupMap.put("generationId", group.getGenerationId());
                groupMap.put("groupCode", group.getGroupCode());

                groupMapList.add(groupMap);
            }
            if (groupMapList.size() > 0) {
                userDAO.insertGroupsList(groupMapList);
            }
        }

        userDAO.updateUser(map);
    }

    @Override
    public void deleteUser(Integer userId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("userId", userId);

        userDAO.removeUser(map);
    }
}
