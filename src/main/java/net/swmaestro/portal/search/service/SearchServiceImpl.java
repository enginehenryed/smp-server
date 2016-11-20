package net.swmaestro.portal.search.service;


import net.swmaestro.portal.assignment.handler.AssignmentHandler;
import net.swmaestro.portal.assignment.vo.AssignmentResult;
import net.swmaestro.portal.lecture.handler.LectureHandler;
import net.swmaestro.portal.lecture.vo.LectureResult;
import net.swmaestro.portal.user.handler.UserHandler;
import net.swmaestro.portal.user.vo.UserResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("searchService")
public class SearchServiceImpl implements SearchService {
	@Resource(name="userHandler")
	private UserHandler userHandler;

	@Resource(name="lectureHandler")
	private LectureHandler lectureHandler;

	@Resource(name="assignmentHandler")
	private AssignmentHandler assignmentHandler;

	@Override
	public Map selectAll(Integer callerId, String query) throws Exception {
		Map resultMap = new HashMap();
		List<UserResult> userResults = userHandler.searchUsers(callerId, query);
		resultMap.put("users", userResults);

		List<LectureResult> lectureResults = lectureHandler.searchLectures(callerId, query);
		resultMap.put("lectures", lectureResults);

		List<AssignmentResult> assignmentResults = assignmentHandler.searchAssignments(callerId, query);
		resultMap.put("assignments", assignmentResults);

		return resultMap;
	}

	@Override
	public List<UserResult> selectUsers(Integer callerId, String query) throws Exception {
		return userHandler.searchUsers(callerId, query);
	}
}
