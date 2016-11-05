package net.swmaestro.portal.lecture.handler;

import net.swmaestro.portal.lecture.dao.LectureDAO;
import net.swmaestro.portal.lecture.vo.Lecture;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by junha on 2016. 11. 6..
 */
@Service("lectureHandler")
public class LectureHandlerImpl implements LectureHandler {

    @Resource(name="lectureDAO")
    private LectureDAO lectureDAO;

    @Override
    public Lecture selectLecture(int lectureId) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("lecture_id", lectureId);

        return lectureDAO.selectLecture(map);
    }
}
