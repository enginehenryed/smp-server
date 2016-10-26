package net.swmaestro.portal.lecture.controller;

import io.swagger.annotations.ApiParam;
import net.swmaestro.portal.auth.JWTAuthentication;
import net.swmaestro.portal.comment.service.CommentService;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.lecture.service.LectureService;
import net.swmaestro.portal.lecture.vo.Lecture;
import net.swmaestro.portal.user.vo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Controller
public class LectureApiController implements LectureApi {

    @Resource(name = "lectureService")
    private LectureService lectureService;


    @Resource(name = "commentService")
    private CommentService commentService;

    public ResponseEntity<Void> deleteLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lecture-id") Integer lectureId


    ) {
        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            lectureService.removeLecture(userId, lectureId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    public ResponseEntity<Lecture> getLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lecture-id") Integer lectureId


    ) {
        Lecture lecture;

        try {
            lecture = lectureService.selectLecture(lectureId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Lecture>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<Lecture>(lecture, HttpStatus.OK);
    }

    public ResponseEntity<List<Lecture>> getLectures() {
        List<Lecture> lectures;
        try {
            lectures = lectureService.selectAllLectures();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Lecture>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Lecture>>(lectures, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> postLecture(@ApiParam(value = "Lecture's articleGenerationId") @RequestBody(required = true) Lecture lecture) {
        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            lectureService.insertLecture(userId, lecture);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> putLecture(@ApiParam(value = "Lecture's ID", required = true) @PathVariable("lecture-id") Integer lectureId,
                                           @ApiParam(value = "Lecture's VO") @RequestBody(required = true) Lecture lecture) {

        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            lectureService.updateLecture(lectureId, userId, lecture);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @Override
    public ResponseEntity<List<Comment>> getCommentsByLectureId(@ApiParam(value = "Lecture's ID", required = true) @PathVariable("lecture-id") Integer lectureId) {
            List<Comment> comments;
            try {
                comments = commentService.selectCommentsByArticleId(lectureId);
            } catch (Exception e) {
                e.printStackTrace();
                return new ResponseEntity<List<Comment>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
        }

    @Override
    public ResponseEntity<Void> postCommentInLecture(@ApiParam(value = "Lecture's ID", required = true) @PathVariable("lecture-id") Integer lectureId, @ApiParam(value = "Comment") @RequestBody(required = true) Comment comment) {
        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            commentService.insertCommentInArticle(lectureId, userId, comment);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
