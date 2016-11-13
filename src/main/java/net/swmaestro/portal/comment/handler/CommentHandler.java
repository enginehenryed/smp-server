package net.swmaestro.portal.comment.handler;

import net.swmaestro.portal.comment.vo.Comment;

public interface CommentHandler {

    Comment selectComment(int commentId) throws Exception;

}
