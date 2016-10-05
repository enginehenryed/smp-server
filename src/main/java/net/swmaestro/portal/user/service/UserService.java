package net.swmaestro.portal.user.service;


import net.swmaestro.portal.user.vo.User;

import java.util.List;
import java.util.Map;

public interface UserService {

	User selectUser(Map<String, Object> map) throws Exception;

}
