package net.swmaestro.portal.lecture.service;


import net.swmaestro.portal.lecture.dao.LectureDAO;
import net.swmaestro.portal.lecture.vo.Lecture;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("lectureService")
public class LectureServiceImpl implements LectureService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="lectureDAO")
	private LectureDAO lectureDAO;
	
	@Override
	public Lecture selectLecture(Map<String, Object> map) throws Exception {
		return lectureDAO.selectLecture(map);
	}

	@Override
	public List selectAllLectures() throws Exception {
		return lectureDAO.selectAllLectures();
	}

}
