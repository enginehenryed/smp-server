package net.swmaestro.portal.comment.permission;

import net.swmaestro.portal.comment.handler.CommentHandler;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.common.permission.Permission;

import javax.annotation.Resource;
import java.io.Serializable;

public class CommentPermission implements Permission {

    @Resource(name="commentHandler")
    private CommentHandler commentHandler;

    @Override
    public boolean isOwner(int authUserId, Serializable targetId) {
        Comment comment = null;
        try {
            comment = commentHandler.selectComment((int)targetId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {}

        return comment.getCommentWriterId() == authUserId;
    }
}
