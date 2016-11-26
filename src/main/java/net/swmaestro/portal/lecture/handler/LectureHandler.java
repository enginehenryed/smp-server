package net.swmaestro.portal.lecture.handler;

import net.swmaestro.portal.lecture.vo.LectureResult;

import java.util.List;

/**
 * Created by junha on 2016. 11. 6..
 */
public interface LectureHandler {

    LectureResult selectLecture(int lectureId) throws Exception;

    List<LectureResult> searchLectures(Integer callerId, String query);
}
