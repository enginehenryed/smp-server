package net.swmaestro.portal.assignment.handler;

import net.swmaestro.portal.assignment.dao.AssignmentDAO;
import net.swmaestro.portal.assignment.vo.AssignmentResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by junha on 2016. 11. 6..
 */
@Service("assignmentHandler")
public class AssignmentHandlerImpl implements AssignmentHandler {

    @Resource(name="assignmentDAO")
    private AssignmentDAO assignmentDAO;

    @Override
    public AssignmentResult selectAssignment(int assignmentId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("assignment_id", assignmentId);

        return assignmentDAO.selectAssignment(map);
    }

    @Override
    public List<AssignmentResult> searchAssignments(Integer callerId, String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("query", query);

        return assignmentDAO.searchAssignments(map);
    }
}
