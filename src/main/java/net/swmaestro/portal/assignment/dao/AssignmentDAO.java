package net.swmaestro.portal.assignment.dao;


import net.swmaestro.portal.assignment.vo.AssignmentResult;
import net.swmaestro.portal.common.dao.AbstractDAO;
import net.swmaestro.portal.user.vo.UserResult;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("assignmentDAO")
public class AssignmentDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public AssignmentResult selectAssignment(Map<String, Object> map) throws Exception{
		return (AssignmentResult) selectOne("assignment.selectAssignment", map);
	}

	@SuppressWarnings("unchecked")
	public List<AssignmentResult> selectAllAssignments() throws Exception{
		return (List<AssignmentResult>) selectList("assignment.selectAllAssignments");
	}

	@SuppressWarnings("unchecked")
	public void insertAssignment(Map<String, Object> map) {
		insert("assignment.insertAssignment", map);
	}

	public void updateAssignment(Map<String, Object> map) {
		update("assignment.updateAssignment",map);
	}

	public void removeAssignment(Map<String, Object> map) {
		update("assignment.removeAssignment",map);
	}

    public List<AssignmentResult> selectAssignmentsByUserId(Map<String, Object> map) {
		return (List<AssignmentResult>) selectList("assignment.selectAssignmentsByUserId", map);
    }

    public List<AssignmentResult> searchAssignments(Map<String, Object> map) {
		return (List<AssignmentResult>) selectList("assignment.searchAssignments", map);
    }
}
