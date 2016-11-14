package net.swmaestro.portal.assignment.service;


import net.swmaestro.portal.assignment.vo.Assignment;
import net.swmaestro.portal.assignment.vo.AssignmentResult;

import java.util.List;

public interface AssignmentService {

	AssignmentResult selectAssignment(int assignmentId) throws Exception;
	List<AssignmentResult> selectAllAssignments(Integer month, Integer year) throws Exception;
	List<AssignmentResult> selectAssignmentsByUserId(Integer userId) throws Exception;

	void insertAssignment(Integer userId, Assignment assignment) throws Exception;

	void removeAssignment(Integer userId, Integer assignmentId) throws Exception;

	void updateAssignment(Integer assignmentId, Integer userId, Assignment assignment);
}
