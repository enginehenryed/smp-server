package net.swmaestro.portal.notification.service;

import net.swmaestro.portal.notification.dao.NotificationDAO;
import net.swmaestro.portal.notification.vo.Notification;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dbgsprw on 2016. 11. 5..
 */

@Service("notificationService")
public class NotificationServiceImpl implements NotificationService {

    @Resource(name="notificationDAO")
    private NotificationDAO notificationDAO;


    @Override
    public List<Notification> getNotificationsByUserId(Integer userId) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_id", userId);

        return notificationDAO.selectNotificationsByUserId(map);
    }

    @Override
    public void readNotification(Integer userId, Integer notificationId) throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("notification_id", notificationId);
        notificationDAO.updateNotificationToBeRead(map);

    }
}
