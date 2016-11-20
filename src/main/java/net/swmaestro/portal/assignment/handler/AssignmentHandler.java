package net.swmaestro.portal.assignment.handler;

import net.swmaestro.portal.assignment.vo.AssignmentResult;

import java.util.List;

/**
 * Created by junha on 2016. 11. 6..
 */
public interface AssignmentHandler {

    AssignmentResult selectAssignment(int assignmentId) throws Exception;

    List<AssignmentResult> searchAssignments(Integer callerId, String query);
}
