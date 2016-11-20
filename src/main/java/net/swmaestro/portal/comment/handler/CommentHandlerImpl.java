package net.swmaestro.portal.comment.handler;

import net.swmaestro.portal.comment.dao.CommentDAO;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.notification.vo.Notification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("commentHandler")
public class CommentHandlerImpl implements CommentHandler {

    @Resource(name="commentDAO")
    private CommentDAO commentDAO;

    @Override
    public Comment selectComment(int commentId) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("comment_id", commentId);

        return commentDAO.selectComment(map);
    }
}
