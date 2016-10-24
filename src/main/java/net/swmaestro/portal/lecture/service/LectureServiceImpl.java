package net.swmaestro.portal.lecture.service;


import net.swmaestro.portal.lecture.dao.LectureDAO;
import net.swmaestro.portal.lecture.vo.Lecture;
import net.swmaestro.portal.user.dao.UserDAO;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service("lectureService")
public class LectureServiceImpl implements LectureService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="lectureDAO")
	private LectureDAO lectureDAO;

	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	@Override
	public Lecture selectLecture(int lectureId) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lecture_id", lectureId);

		return lectureDAO.selectLecture(map);
	}

	@Override
	public List selectAllLectures() throws Exception {
		return lectureDAO.selectAllLectures();
	}

	@Override
	public void insertLecture(Integer userId, Lecture lecture) throws Exception {

		Map<String, Object> map = new HashMap<String, Object>();

		map.put("article_writer_id", userId);
		map.put("article_modifier_id", userId);
		map.put("article_generation_id", lecture.getArticleGenerationId());
		map.put("article_subject", lecture.getArticleSubject());
		map.put("article_content", lecture.getArticleContent());

		map.put("lecture_teacher_id", lecture.getLectureTeacherId());
		map.put("lecture_begin_at", lecture.getLectureBeginAt());
		map.put("lecture_end_at", lecture.getLectureEndAt());

		lectureDAO.insertLecture(map);

	}

	@Override
	public void removeLecture(Integer userId, Integer lectureId) throws Exception {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lecture_id", lectureId);

		lectureDAO.removeLecture(map);

	}

	@Override
	public void updateLecture(Integer lectureId, Integer userId, Lecture lecture) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lecture_id", lectureId);

		if(userId != null) {
			map.put("article_modifier_id", userId);
		}
		if(lecture.getArticleGenerationId() != null) {
			map.put("article_generation_id", lecture.getArticleGenerationId());
		}
		if(lecture.getArticleSubject() != null) {
			map.put("article_subject", lecture.getArticleSubject());
		}
		if(lecture.getArticleContent() != null) {
			map.put("article_content", lecture.getArticleContent());
		}

		if(lecture.getLectureTeacherId() != null) {
			map.put("lecture_teacher_id", lecture.getLectureTeacherId());
		}
		if(lecture.getLectureBeginAt() != null) {
			map.put("lecture_begin_at", lecture.getLectureBeginAt());
		}
		if(lecture.getLectureEndAt() != null) {
			map.put("lecture_end_at", lecture.getLectureEndAt());
		}

		lectureDAO.updateLecture(map);
	}

}
