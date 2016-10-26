package net.swmaestro.portal.comment.service;


import net.swmaestro.portal.comment.vo.Comment;

import java.util.List;

public interface CommentService {

	List selectCommentsByArticleId(int articleId) throws Exception;
	void insertCommentInArticle(int articleId, Integer userId, Comment comment) throws Exception;
	void removeComment(Integer userId, Integer commentId) throws Exception;
	void updateComment(Integer commentId, Integer userId, Comment comment) throws Exception;
//	List selectCommentsByUserId(int userId) throws Exception;
//	Comment selectComment() throws Exception;
/*
	void insertComment(int articleId, Integer userId, Comment comment) throws Exception;

	void removeLecture(Integer userId, Integer lectureId) throws Exception;

	void updateComment(Integer lectureId, Integer userId, Comment comment);*/
}
