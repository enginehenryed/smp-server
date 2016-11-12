package net.swmaestro.portal.comment.service;


import net.swmaestro.portal.comment.dao.CommentDAO;
import net.swmaestro.portal.comment.vo.Comment;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="commentDAO")
	private CommentDAO commentDAO;

	@Override
	public List selectCommentsByArticleId(int articleId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("article_id", articleId);

		return commentDAO.selectCommentsByArticleId(map);
	}

	@Override
	public void insertCommentInArticle(int articleId, Integer userId, Comment comment) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("comment_writer_id", userId);
		map.put("comment_content", comment.getCommentContent());
		map.put("comment_parent_id", comment.getCommentParentId());
		map.put("article_id", articleId);

		commentDAO.insertCommentInArticle(map);
	}

	@Override
	public void removeComment(Integer userId, Integer commentId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("comment_id", commentId);

		commentDAO.removeComment(map);
	}

	@Override
	public void updateComment(Integer commentId, Integer userId, Comment comment) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("comment_id", commentId);

		if(comment.getCommentContent() != null) {
			map.put("comment_content", comment.getCommentContent());
		}

		commentDAO.updateComment(map);
	}

	@Override
	public List<Comment> selectCommentsByUserId(Integer userId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("user_id", userId);

		return commentDAO.selectCommentsByUserId(map);
	}
}
