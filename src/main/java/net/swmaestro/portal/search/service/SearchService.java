package net.swmaestro.portal.search.service;


import net.swmaestro.portal.user.vo.UserResult;

import java.util.List;
import java.util.Map;

public interface SearchService {

	Map selectAll(Integer userId, String query) throws Exception;

	List<UserResult> selectUsers(Integer userId, String query) throws Exception;
}
