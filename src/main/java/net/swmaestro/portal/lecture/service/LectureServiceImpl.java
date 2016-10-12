package net.swmaestro.portal.lecture.service;


import net.swmaestro.portal.lecture.dao.LectureDAO;
import net.swmaestro.portal.lecture.vo.Lecture;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("lectureService")
public class LectureServiceImpl implements LectureService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="lectureDAO")
	private LectureDAO lectureDAO;
	
	@Override
	public Lecture selectLecture(int lectureId) throws Exception {
		//TODO
		// 여기서 맵을만들어서 DAO 호출
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("lecture_id", lectureId);

		return lectureDAO.selectLecture(map);
	}

	@Override
	public List selectAllLectures() throws Exception {
		return lectureDAO.selectAllLectures();
	}

}
