package net.swmaestro.portal.notification.service;

import net.swmaestro.portal.notification.vo.Notification;

import java.util.List;

/**
 * Created by dbgsprw on 2016. 11. 5..
 */

public interface NotificationService {
    List<Notification> getNotificationsByUserId(Integer userId) throws Exception;

    void readNotification(Integer userId, Integer notificationId)  throws Exception;

    void sendNotification(Integer targetUserId, String notificationMessage, String notificationUrl) throws Exception;
}
