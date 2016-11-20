package net.swmaestro.portal.notification.permission;

import net.swmaestro.portal.assignment.handler.AssignmentHandler;
import net.swmaestro.portal.assignment.vo.Assignment;
import net.swmaestro.portal.common.permission.Permission;
import net.swmaestro.portal.notification.handler.NotificationHandler;
import net.swmaestro.portal.notification.vo.Notification;

import javax.annotation.Resource;
import java.io.Serializable;

public class NotificationPermission implements Permission {

    @Resource(name="notificationHandler")
    private NotificationHandler notificationHandler;

    @Override
    public boolean isOwner(int authUserId, Serializable targetId) {
        Notification notification = null;
        try {
            notification = notificationHandler.selectNotification((int)targetId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {}

        return notification.getNotificationTargetUserId() == authUserId;
    }
}
