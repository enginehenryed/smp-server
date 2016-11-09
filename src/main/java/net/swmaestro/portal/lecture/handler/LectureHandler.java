package net.swmaestro.portal.lecture.handler;

import net.swmaestro.portal.lecture.vo.Lecture;

/**
 * Created by junha on 2016. 11. 6..
 */
public interface LectureHandler {

    Lecture selectLecture(int lectureId) throws Exception;

}
