package net.swmaestro.portal.lecture.dao;


import net.swmaestro.portal.common.dao.AbstractDAO;
import net.swmaestro.portal.lecture.vo.LectureResult;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository("lectureDAO")
public class LectureDAO extends AbstractDAO{

	@SuppressWarnings("unchecked")
	public LectureResult selectLecture(Map<String, Object> map) throws Exception{
		return (LectureResult) selectOne("lecture.selectLecture", map);
	}

	@SuppressWarnings("unchecked")
	public List<LectureResult> selectAllLectures() throws Exception{
		return (List<LectureResult>) selectList("lecture.selectAllLectures");
	}

	@SuppressWarnings("unchecked")
	public void insertLecture(Map<String, Object> map) {
		insert("lecture.insertLecture", map);
	}

	public void updateLecture(Map<String, Object> map) {
		update("lecture.updateLecture",map);
	}

	public void removeLecture(Map<String, Object> map) {
		update("lecture.removeLecture",map);
	}

	public List<LectureResult> selectLecturesByUserId(Map<String, Object> map) throws Exception{
		return (List<LectureResult>) selectList("lecture.selectLecturesByUserId", map);
	}
}
