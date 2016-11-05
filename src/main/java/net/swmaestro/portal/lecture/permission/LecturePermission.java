package net.swmaestro.portal.lecture.permission;

import net.swmaestro.portal.common.permission.Permission;
import net.swmaestro.portal.lecture.handler.LectureHandler;
import net.swmaestro.portal.lecture.vo.Lecture;

import javax.annotation.Resource;
import java.io.Serializable;

/**
 * Created by junha on 2016. 11. 6..
 */
public class LecturePermission implements Permission {

    @Resource(name="lectureHandler")
    private LectureHandler lectureHandler;

    @Override
    public boolean isOwner(int authUserId, Serializable targetId) {
        Lecture lecture = null;
        try {
            lecture = lectureHandler.selectLecture((int)targetId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {}

        return lecture.getArticleWriterId() == authUserId;
    }
}
