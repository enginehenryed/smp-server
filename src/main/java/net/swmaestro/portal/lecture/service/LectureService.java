package net.swmaestro.portal.lecture.service;


import net.swmaestro.portal.lecture.vo.Lecture;
import net.swmaestro.portal.lecture.vo.LectureResult;

import java.util.List;

public interface LectureService {

	LectureResult selectLecture(int lectureId) throws Exception;
	List<LectureResult> selectAllLectures(Integer month, Integer year) throws Exception;

	void insertLecture(Integer userId, Lecture lecture) throws Exception;

	void removeLecture(Integer userId, Integer lectureId) throws Exception;

	void updateLecture(Integer lectureId, Integer userId, Lecture lecture) throws Exception;

    List<LectureResult> selectLecturesByUserId(Integer user) throws Exception;

}
