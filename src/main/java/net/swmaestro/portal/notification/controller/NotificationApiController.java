package net.swmaestro.portal.notification.controller;

import io.swagger.annotations.ApiParam;
import net.swmaestro.portal.auth.JWTAuthentication;
import net.swmaestro.portal.notification.service.NotificationService;
import net.swmaestro.portal.notification.vo.Notification;
import net.swmaestro.portal.user.vo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by dbgsprw on 2016. 11. 5..
 */

@Controller
public class NotificationApiController implements NotificationApi{

   @Resource(name = "notificationService")
   private NotificationService notificationService;


    @Override
    public ResponseEntity<List<Notification>> getMyNotifications() {
        List<Notification> notifications;
        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            notifications = notificationService.getNotificationsByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Notification>>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<List<Notification>>(notifications, HttpStatus.OK);
    }
}
