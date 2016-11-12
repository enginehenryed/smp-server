package net.swmaestro.portal.user.controller;

import net.swmaestro.portal.assignment.service.AssignmentService;
import net.swmaestro.portal.assignment.vo.Assignment;
import net.swmaestro.portal.auth.JWTAuthentication;
import net.swmaestro.portal.comment.service.CommentService;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.lecture.service.LectureService;
import net.swmaestro.portal.lecture.vo.Lecture;
import net.swmaestro.portal.user.service.UserService;
import net.swmaestro.portal.user.vo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

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

    public ResponseEntity<Void> deleteMe() {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteUser(
        @PathVariable("userId") Integer userId
    ) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<User> getMe() {
        // do some magic!
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    public ResponseEntity<User> getUser(
        @PathVariable("user-id") Integer userId
    ) {
        User user;

        try {
            user = userService.selectUser(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    public ResponseEntity<List<User>> getUsers(
            @RequestParam(value = "userEmail", required = false) String userEmail
    ) {
        return new ResponseEntity<List<User>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> postUser(@RequestBody(required = true) User user) throws Exception {
        int user_id;
        try {
            user_id = userService.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally { }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> putMe(@RequestBody(required = true) User user) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> putUser(
            @PathVariable("userId") Integer userId,
            @RequestBody(required = true) User user
    ) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Lecture>> getMyLectures() {
        List<Lecture> lectures;
        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            lectures = lectureService.selectLecturesByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Lecture>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Lecture>>(lectures, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Assignment>> getMyAssignments() {
        List<Assignment> assignments;
        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            assignments = assignmentService.selectAssignmentsByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Assignment>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Assignment>>(assignments, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<Comment>> getMyComments() {
        List<Comment> comments;
        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            comments = commentService.selectCommentsByUserId(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Comment>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
    }


}
