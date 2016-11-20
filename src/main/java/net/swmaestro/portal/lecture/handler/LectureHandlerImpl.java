package net.swmaestro.portal.lecture.handler;

import net.swmaestro.portal.assignment.vo.AssignmentResult;
import net.swmaestro.portal.lecture.dao.LectureDAO;
import net.swmaestro.portal.lecture.vo.LectureResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by junha on 2016. 11. 6..
 */
@Service("lectureHandler")
public class LectureHandlerImpl implements LectureHandler {

    @Resource(name="lectureDAO")
    private LectureDAO lectureDAO;

    @Override
    public LectureResult selectLecture(int lectureId) throws Exception {
        Map<String, Object> map = new HashMap<>();
        map.put("lecture_id", lectureId);

        return lectureDAO.selectLecture(map);
    }


    @Override
    public List<LectureResult> searchLectures(Integer callerId, String query) {
        Map<String, Object> map = new HashMap<>();
        map.put("query", query);

        return lectureDAO.searchLectures(map);
    }
}
