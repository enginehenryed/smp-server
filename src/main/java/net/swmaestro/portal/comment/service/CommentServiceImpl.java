package net.swmaestro.portal.comment.service;


import net.swmaestro.portal.assignment.dao.AssignmentDAO;
import net.swmaestro.portal.assignment.vo.AssignmentResult;
import net.swmaestro.portal.comment.dao.CommentDAO;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.lecture.dao.LectureDAO;
import net.swmaestro.portal.lecture.vo.LectureResult;
import net.swmaestro.portal.notification.service.NotificationService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="assignmentDAO")
	private AssignmentDAO assignmentDAO;

	@Resource(name="lectureDAO")
	private LectureDAO lectureDAO;

	@Resource(name="commentDAO")
	private CommentDAO commentDAO;


	@Resource(name = "notificationService")
	private NotificationService notificationService;


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

		Integer targetUserId = null;

		Map<String, Object> lectureMap = new HashMap<>();
		lectureMap.put("lecture_id", articleId);
		LectureResult lecture = lectureDAO.selectLecture(lectureMap);

		Map<String, Object> assignmentMap = new HashMap<>();
		assignmentMap.put("assignment_id", articleId);
		AssignmentResult assignment = assignmentDAO.selectAssignment(assignmentMap);

		String type = null;
		if (lecture != null) {
			targetUserId = lecture.getArticleWriter().getUserId();
			type = "lectures";
		}

		if (assignment != null) {
			targetUserId = assignment.getArticleWriter().getUserId();
			type = "assignments";
		}

		if (targetUserId != null && !userId.equals(targetUserId)) {
			if (type == null) {
				log.error("Invalid article type of comment!");
			}
			notificationService.sendNotification(
					targetUserId,
					"회원님의 글에 덧글이 달렸습니다.",
					String.format("/%s/%d#comment-%d", type, articleId, (long)map.get("commentId"))
			);
		}
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
