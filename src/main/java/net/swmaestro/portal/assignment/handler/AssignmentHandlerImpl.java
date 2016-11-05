package net.swmaestro.portal.assignment.handler;

import net.swmaestro.portal.assignment.dao.AssignmentDAO;
import net.swmaestro.portal.assignment.vo.Assignment;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by junha on 2016. 11. 6..
 */
@Service("assignmentHandler")
public class AssignmentHandlerImpl implements AssignmentHandler {

    @Resource(name="assignmentDAO")
    private AssignmentDAO assignmentDAO;

    @Override
    public Assignment selectAssignment(int assignmentId) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("assignment_id", assignmentId);

        return assignmentDAO.selectAssignment(map);
    }
}
