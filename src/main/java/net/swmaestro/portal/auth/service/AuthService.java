package net.swmaestro.portal.auth.service;


import java.util.List;
import java.util.Map;

public interface AuthService {

	List<Map<String, Object>> getUserByEmail(Map<String, Object> map) throws Exception;

}
