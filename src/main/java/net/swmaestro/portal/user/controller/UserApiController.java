package net.swmaestro.portal.user.controller;

import net.swmaestro.portal.assignment.service.AssignmentService;
import net.swmaestro.portal.assignment.vo.AssignmentResult;
import net.swmaestro.portal.auth.JWTAuthentication;
import net.swmaestro.portal.comment.service.CommentService;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.lecture.service.LectureService;
import net.swmaestro.portal.lecture.vo.LectureResult;
import net.swmaestro.portal.user.service.UserService;
import net.swmaestro.portal.user.vo.User;
import net.swmaestro.portal.user.vo.UserResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import javax.annotation.Resource;
import java.util.List;


@Controller
public class UserApiController implements UserApi {

    @Resource(name="userService")
    private UserService userService;

    @Resource(name="lectureService")
    private LectureService lectureService;

    @Resource(name="assignmentService")
    private AssignmentService assignmentService;

    @Resource(name="commentService")
    private CommentService commentService;

    public ResponseEntity<Void> deleteMe() throws Exception {
        JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
        UserResult user = authentication.getUser();

        userService.deleteUser(user.getUserId());
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasPermission(null, 'ADMIN')")
    public ResponseEntity<Void> deleteUser(
        @PathVariable("user-id") Integer userId
    ) throws Exception {
        userService.deleteUser(userId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public ResponseEntity<UserResult> getMe() throws Exception {
        JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
        UserResult user = authentication.getUser();

        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<UserResult> getUser(
        @PathVariable("user-id") Integer userId
    ) throws Exception {
        JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
        Integer callerId = authentication.getUser().getUserId();
        UserResult user;
        user = userService.selectUser(callerId, userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    public ResponseEntity<List<UserResult>> getUsers() throws Exception {
        JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
        Integer callerId = authentication.getUser().getUserId();
        List<UserResult> users;
        users = userService.selectAllUsers(callerId);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    public ResponseEntity<Void> postUser(@RequestBody User user) throws Exception {
        userService.insertUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public ResponseEntity<Void> putMe(@RequestBody User user) throws Exception {
        JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
        UserResult authenticatedUser = authentication.getUser();

        user.setUserId(authenticatedUser.getUserId());
        user.setUserGroups(null);
        userService.updateUser(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasPermission(null, 'ADMIN')")
    public ResponseEntity<Void> putUser(
            @PathVariable("user-id") Integer userId,
            @RequestBody User user
    ) throws Exception {
        user.setUserId(userId);
        userService.updateUser(user);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<LectureResult>> getMyLectures() throws Exception {
        JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
        UserResult user = authentication.getUser();

        List<LectureResult> lectures;
        lectures = lectureService.selectLecturesByUserId(user.getUserId());
        return new ResponseEntity<>(lectures, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<AssignmentResult>> getMyAssignments() throws Exception {
        JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
        UserResult user = authentication.getUser();

        List<AssignmentResult> assignments;
        assignments = assignmentService.selectAssignmentsByUserId(user.getUserId());
        return new ResponseEntity<>(assignments, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Comment>> getMyComments() throws Exception {
        JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
        UserResult user = authentication.getUser();

        List<Comment> comments;
        comments = commentService.selectCommentsByUserId(user.getUserId());
        return new ResponseEntity<>(comments, HttpStatus.OK);
    }


}
