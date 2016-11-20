package net.swmaestro.portal.comment.dao;


import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.common.dao.AbstractDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("commentDAO")
public class CommentDAO extends AbstractDAO{


	public List<Comment> selectCommentsByArticleId(Map<String, Object> map) throws Exception {
		return (List<Comment>) selectList("comment.selectCommentsByArticleId", map);
	}
	/*
	public List<Comment> selectCommentsByUserId(Map<String, Object> map) throws Exception {
		return (List<Comment>) selectList("lecture.selectLecture", map);
	}*/
	/*
	public Comment selectComment(Map<String, Object> map) throws Exception {
		return (Comment) selectOne("lecture.selectLecture", map);
	}*/

	@SuppressWarnings("unchecked")
	public void insertCommentInArticle(Map<String, Object> map) {
		insert("comment.insertCommentInArticle", map);
	}

	public void updateComment(Map<String, Object> map) {
		update("comment.updateComment",map);
	}

	public void removeComment(Map<String, Object> map) {
		update("comment.removeComment",map);
	}

    public List<Comment> selectCommentsByUserId(Map<String, Object> map) {
		return (List<Comment>) selectList("comment.selectCommentsByUserId", map);
    }

	public Comment selectComment(Map<String, Object> map) {
		return (Comment)selectOne("comment.selectComment", map);
	}
}
