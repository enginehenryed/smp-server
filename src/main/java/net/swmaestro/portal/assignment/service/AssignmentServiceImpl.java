package net.swmaestro.portal.assignment.service;


import net.swmaestro.portal.assignment.dao.AssignmentDAO;
import net.swmaestro.portal.assignment.vo.Assignment;
import net.swmaestro.portal.user.dao.UserDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("assignmentService")
public class AssignmentServiceImpl implements AssignmentService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="assignmentDAO")
	private AssignmentDAO assignmentDAO;

	@Resource(name="userDAO")
	private UserDAO userDAO;

	@Override
	public Assignment selectAssignment(int assignmentId) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("assignment_id", assignmentId);

		return assignmentDAO.selectAssignment(map);
	}

	@Override
	public List selectAllAssignments() throws Exception {
		return assignmentDAO.selectAllAssignments();
	}

	@Override
	public void insertAssignment(Integer userId, Assignment assignment) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("article_writer_id", userId);
		map.put("article_modifier_id", userId);
		map.put("article_generation_id", assignment.getArticleGenerationId());
		map.put("article_subject", assignment.getArticleSubject());
		map.put("article_content", assignment.getArticleContent());
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		map.put("article_created_at", dateFormat.format(date));
		map.put("article_updated_at", dateFormat.format(date));
		map.put("article_type", "0");
		map.put("article_status", "0");

		map.put("assignment_end_at", assignment.getAssignmentEndAt());

		assignmentDAO.insertAssignment(map);

	}

	@Override
	public void removeAssignment(Integer userId, Integer assignmentId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("assignment_id", assignmentId);

		assignmentDAO.removeAssignment(map);

	}

	@Override
	public void updateAssignment(Integer assignmentId, Integer userId, Assignment assignment) {
		Map<String, Object> map = new HashMap<String, Object>();
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
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date();
		map.put("article_updated_at", dateFormat.format(date));
		/*
		TODO
		map.put("article_status", "0");
		*/
		if(assignment.getAssignmentEndAt() != null) {
			map.put("assignment_end_at", assignment.getAssignmentEndAt());
		}

		assignmentDAO.updateAssignment(map);
	}

}
