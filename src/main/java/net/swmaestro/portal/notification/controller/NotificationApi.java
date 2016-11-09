package net.swmaestro.portal.notification.controller;

import io.swagger.annotations.*;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.notification.vo.Notification;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by dbgsprw on 2016. 11. 5..
 */
public interface NotificationApi {

    @RequestMapping(value = "/notifications/me",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Notification>> getMyNotifications(
    );
}
