package net.swmaestro.portal.lecture.dao;


import net.swmaestro.portal.common.dao.AbstractDAO;
import net.swmaestro.portal.lecture.vo.Lecture;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("lectureDAO")
public class LectureDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public Lecture selectLecture(Map<String, Object> map) throws Exception{
		return (Lecture) selectOne("lecture.selectLecture", map);
	}

	@SuppressWarnings("unchecked")
	public List<Lecture> selectAllLectures() throws Exception{
		return (List<Lecture>) selectList("lecture.selectAllLectures");
	}

	@SuppressWarnings("unchecked")
	public void insertLecture(Map<String, Object> map) {
		insert("lecture.insertArticle", map);
		insert("lecture.insertLecture", map);
	}

	public void deleteLecture(Map<String, Object> map) {
		delete("lecture.deleteLecture", map);
		delete("lecture.deleteArticle", map);
	}
}
