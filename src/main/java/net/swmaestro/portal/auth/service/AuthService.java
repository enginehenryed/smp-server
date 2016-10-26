package net.swmaestro.portal.auth.service;


import net.swmaestro.portal.user.vo.User;

import java.util.Map;

public interface AuthService {

	String getToken(String email, String password);

}
