package net.swmaestro.portal.assignment.permission;

import net.swmaestro.portal.assignment.handler.AssignmentHandler;
import net.swmaestro.portal.assignment.vo.AssignmentResult;
import net.swmaestro.portal.common.permission.Permission;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by junha on 2016. 11. 6..
 */
public class AssignmentPermission implements Permission {

    @Resource(name="assignmentHandler")
    private AssignmentHandler assignmentHandler;

    @Override
    public boolean isOwner(int authUserId, Serializable targetId) {
        AssignmentResult assignment = null;
        try {
            assignment = assignmentHandler.selectAssignment((int)targetId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {}

        return assignment.getArticleWriter().getUserId() == authUserId;
    }
}
