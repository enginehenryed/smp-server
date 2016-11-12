package net.swmaestro.portal.notification.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * Created by dbgsprw on 2016. 11. 5..
 */
public class Notification {

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String TIME_ZONE = "Asia/Seoul";


    private Integer notificationId = null;

    private String notificationMessage = null;

    private String notificationUrl = null;

    private Integer notificationTargetUserId = null;


    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone = TIME_ZONE)
    private Date notificationCreatedAt = null;

    private boolean notificationIsRead;

    public Integer getNotificationId() {
        return notificationId;
    }

    public void setNotificationId(Integer notificationId) {
        this.notificationId = notificationId;
    }

    public String getNotificationMessage() {
        return notificationMessage;
    }

    public void setNotificationMessage(String notificationMessage) {
        this.notificationMessage = notificationMessage;
    }

    public String getNotificationUrl() {
        return notificationUrl;
    }

    public void setNotificationUrl(String notificationUrl) {
        this.notificationUrl = notificationUrl;
    }

    public Integer getNotificationTargetUserId() {
        return notificationTargetUserId;
    }

    public void setNotificationTargetUserId(Integer notificationTargetUserId) {
        this.notificationTargetUserId = notificationTargetUserId;
    }

    public Date getNotificationCreatedAt() {
        return notificationCreatedAt;
    }

    public void setNotificationCreatedAt(Date notificationCreatedAt) {
        this.notificationCreatedAt = notificationCreatedAt;
    }

    public boolean isNotificationIsRead() {
        return notificationIsRead;
    }

    public void setNotificationIsRead(boolean notificationIsRead) {
        this.notificationIsRead = notificationIsRead;
    }
}
