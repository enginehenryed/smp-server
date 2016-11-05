package net.swmaestro.portal.assignment.handler;

import net.swmaestro.portal.assignment.vo.Assignment;

/**
 * Created by junha on 2016. 11. 6..
 */
public interface AssignmentHandler {

    Assignment selectAssignment(int assignmentId) throws Exception;

}
