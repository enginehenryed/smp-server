package net.swmaestro.portal.assignment.service;


import net.swmaestro.portal.assignment.vo.Assignment;

import java.util.List;

public interface AssignmentService {

	Assignment selectAssignment(int assignmentId) throws Exception;
	List selectAllAssignments() throws Exception;

	void insertAssignment(Integer userId, Assignment assignment) throws Exception;

	void removeAssignment(Integer userId, Integer assignmentId) throws Exception;

	void updateAssignment(Integer assignmentId, Integer userId, Assignment assignment);
}
