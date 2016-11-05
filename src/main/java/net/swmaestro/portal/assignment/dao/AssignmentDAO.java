package net.swmaestro.portal.assignment.dao;


import net.swmaestro.portal.assignment.vo.Assignment;
import net.swmaestro.portal.common.dao.AbstractDAO;
import net.swmaestro.portal.lecture.vo.Lecture;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("assignmentDAO")
public class AssignmentDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public Assignment selectAssignment(Map<String, Object> map) throws Exception{
		return (Assignment) selectOne("assignment.selectAssignment", map);
	}

	@SuppressWarnings("unchecked")
	public List<Assignment> selectAllAssignments() throws Exception{
		return (List<Assignment>) selectList("assignment.selectAllAssignments");
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

    public List<Assignment> selectAssignmentsByUserId(Map<String, Object> map) {
		return (List<Assignment>) selectList("assignment.selectAssignmentsByUserId", map);
    }
}
