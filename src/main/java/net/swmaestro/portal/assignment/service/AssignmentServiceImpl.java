package net.swmaestro.portal.assignment.service;


import net.swmaestro.portal.assignment.dao.AssignmentDAO;
import net.swmaestro.portal.assignment.vo.Assignment;
import net.swmaestro.portal.assignment.vo.AssignmentResult;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.*;

@Service("assignmentService")
public class AssignmentServiceImpl implements AssignmentService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="assignmentDAO")
	private AssignmentDAO assignmentDAO;

	@Override
	public AssignmentResult selectAssignment(int assignmentId) throws Exception {

		Map<String, Object> map = new HashMap<>();
		map.put("assignment_id", assignmentId);

		return assignmentDAO.selectAssignment(map);
	}

	@Override
	public List<AssignmentResult> selectAllAssignments(Integer month, Integer year) throws Exception {
		List<AssignmentResult> assignments = assignmentDAO.selectAllAssignments();
		if (month == null && year == null) {
			return assignments;
		}
		List<AssignmentResult> selectedAssignments = new ArrayList<>();
		Calendar calendar = Calendar.getInstance();
		for (AssignmentResult assignment : assignments) {
			Date endAt = assignment.getAssignmentEndAt();
			calendar.setTime(endAt);
			int endYear = calendar.get(Calendar.YEAR);
			int endMonth = calendar.get(Calendar.MONTH) + 1;
			if (year == endYear && month == endMonth) {
				selectedAssignments.add(assignment);
			}
		}
		return selectedAssignments;
	}

	@Override
	public void insertAssignment(Integer userId, Assignment assignment) throws Exception {

		Map<String, Object> map = new HashMap<>();

		map.put("article_writer_id", userId);
		map.put("article_modifier_id", userId);
		map.put("article_generation_id", assignment.getArticleGenerationId());
		map.put("article_subject", assignment.getArticleSubject());
		map.put("article_content", assignment.getArticleContent());

		map.put("assignment_end_at", assignment.getAssignmentEndAt());

		assignmentDAO.insertAssignment(map);

	}

	@Override
	public void removeAssignment(Integer userId, Integer assignmentId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("assignment_id", assignmentId);

		assignmentDAO.removeAssignment(map);

	}

	@Override
	public void updateAssignment(Integer assignmentId, Integer userId, Assignment assignment) {
		Map<String, Object> map = new HashMap<>();
		map.put("assignment_id", assignmentId);

		if(userId != null) {
			map.put("article_modifier_id", userId);
		}
		if(assignment.getArticleGenerationId() != null) {
			map.put("article_generation_id", assignment.getArticleGenerationId());
		}
		if(assignment.getArticleSubject() != null) {
			map.put("article_subject", assignment.getArticleSubject());
		}
		if(assignment.getArticleContent() != null) {
			map.put("article_content", assignment.getArticleContent());
		}
		if(assignment.getAssignmentEndAt() != null) {
			map.put("assignment_end_at", assignment.getAssignmentEndAt());
		}

		assignmentDAO.updateAssignment(map);
	}


	@Override
	public List<AssignmentResult> selectAssignmentsByUserId(Integer userId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("user_id", userId);

		return assignmentDAO.selectAssignmentsByUserId(map);
	}

}
