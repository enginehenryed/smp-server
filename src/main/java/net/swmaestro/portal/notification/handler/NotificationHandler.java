package net.swmaestro.portal.notification.handler;

import net.swmaestro.portal.notification.vo.Notification;

public interface NotificationHandler {

    Notification selectNotification(int notificationId) throws Exception;

}
