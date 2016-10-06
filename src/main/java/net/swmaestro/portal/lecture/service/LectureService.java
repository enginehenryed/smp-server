package net.swmaestro.portal.lecture.service;


import net.swmaestro.portal.lecture.vo.Lecture;

import java.util.List;
import java.util.Map;

public interface LectureService {

	Lecture selectLecture(Map<String, Object> map) throws Exception;
	List selectAllLectures() throws Exception;

}
