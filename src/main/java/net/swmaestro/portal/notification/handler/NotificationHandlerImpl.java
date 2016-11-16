package net.swmaestro.portal.notification.handler;

import net.swmaestro.portal.lecture.dao.LectureDAO;
import net.swmaestro.portal.lecture.vo.Lecture;
import net.swmaestro.portal.notification.dao.NotificationDAO;
import net.swmaestro.portal.notification.vo.Notification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service("notificationHandler")
public class NotificationHandlerImpl implements NotificationHandler {

    @Resource(name="notificationDAO")
    private NotificationDAO notificationDAO;

    @Override
    public Notification selectNotification(int notificationId) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("notification_id", notificationId);

        return notificationDAO.selectNotification(map);
    }
}
