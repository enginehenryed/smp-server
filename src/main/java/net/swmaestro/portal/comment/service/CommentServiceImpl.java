package net.swmaestro.portal.comment.service;


import net.swmaestro.portal.comment.dao.CommentDAO;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.user.dao.UserDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
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
}
