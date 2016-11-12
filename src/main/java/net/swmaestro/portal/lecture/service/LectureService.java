package net.swmaestro.portal.lecture.service;


import net.swmaestro.portal.lecture.vo.Lecture;

import java.util.List;

public interface LectureService {

	Lecture selectLecture(int lectureId) throws Exception;
	List selectAllLectures(Integer month, Integer year) throws Exception;

	void insertLecture(Integer userId, Lecture lecture) throws Exception;

	void removeLecture(Integer userId, Integer lectureId) throws Exception;

	void updateLecture(Integer lectureId, Integer userId, Lecture lecture);

    List<Lecture> selectLecturesByUserId(Integer user) throws Exception;

}
