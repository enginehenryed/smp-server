package net.swmaestro.portal.comment.controller;

import io.swagger.annotations.ApiParam;
import net.swmaestro.portal.auth.JWTAuthentication;
import net.swmaestro.portal.comment.service.CommentService;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.user.vo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Controller
public class CommentsApiController {//implements CommentsApi {

    @Resource(name = "commentService")
    private CommentService commentService;
}
/*
    public ResponseEntity<Void> deleteLecture(
            @ApiParam(value = "Comment's ID", required = true) @PathVariable("lecture-id") Integer lectureId


    ) {
        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            commentService.removeLecture(userId, lectureId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    public ResponseEntity<Comment> getLecture(
            @ApiParam(value = "Comment's ID", required = true) @PathVariable("lecture-id") Integer lectureId


    ) {
        Comment comment;

        try {
            comment = commentService.selectLecture(lectureId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Comment>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }

    public ResponseEntity<List<Comment>> getLectures() {
        List<Comment> comments;
        try {
            comments = commentService.selectAllLectures();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Comment>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> postLecture(@ApiParam(value = "Comment's articleGenerationId") @RequestBody(required = true) Comment comment) {
        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            commentService.insertLecture(userId, comment);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> putLecture(@ApiParam(value = "Comment's ID", required = true) @PathVariable("lecture-id") Integer lectureId,
                                           @ApiParam(value = "Comment's VO") @RequestBody(required = true) Comment comment) {

        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            commentService.updateLecture(lectureId, userId, comment);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}*/
