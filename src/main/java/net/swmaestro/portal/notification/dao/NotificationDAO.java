package net.swmaestro.portal.notification.dao;

import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.common.dao.AbstractDAO;
import net.swmaestro.portal.notification.vo.Notification;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by dbgsprw on 2016. 11. 5..
 */

@Repository("notificationDAO")
public class NotificationDAO extends AbstractDAO {

    public List<Notification> selectNotificationsByUserId(Map<String, Object> map) throws Exception {
        return (List<Notification>) selectList("notification.selectNotificationsByUserId", map);
    }

    public void updateNotificationToBeRead(Map<String, Object> map) {
        update("notification.updateNotificationToBeRead",map);
    }

    public void insertNotification(Map<String, Object> map) {
        insert("notification.insertNotification", map);
    }
}
