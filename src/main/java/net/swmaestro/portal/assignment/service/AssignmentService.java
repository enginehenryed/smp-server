package net.swmaestro.portal.assignment.service;


import net.swmaestro.portal.assignment.vo.Assignment;
import org.springframework.expression.spel.ast.Assign;

import java.util.List;

public interface AssignmentService {

	Assignment selectAssignment(int assignmentId) throws Exception;
	List selectAllAssignments(Integer month, Integer year) throws Exception;
	List<Assignment> selectAssignmentsByUserId(Integer user) throws Exception;

	void insertAssignment(Integer userId, Assignment assignment) throws Exception;

	void removeAssignment(Integer userId, Integer assignmentId) throws Exception;

	void updateAssignment(Integer assignmentId, Integer userId, Assignment assignment);
}
