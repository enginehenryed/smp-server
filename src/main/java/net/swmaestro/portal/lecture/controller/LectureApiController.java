package net.swmaestro.portal.lecture.controller;

import io.swagger.annotations.ApiParam;
import net.swmaestro.portal.auth.JWTAuthentication;
import net.swmaestro.portal.comment.service.CommentService;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.lecture.service.LectureService;
import net.swmaestro.portal.lecture.vo.Lecture;
import net.swmaestro.portal.lecture.vo.LectureResult;
import net.swmaestro.portal.user.vo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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

    @PreAuthorize("hasPermission(#lectureId, 'Lecture', 'OWNER') OR hasPermission(null, 'ADMIN')")
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


    public ResponseEntity<LectureResult> getLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lecture-id") Integer lectureId


    ) {
        LectureResult lecture;

        try {
            lecture = lectureService.selectLecture(lectureId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<>(lecture, HttpStatus.OK);
    }

    public ResponseEntity<List<LectureResult>> getLectures(
            @RequestParam(value="userId", required=false) Integer userId,
            @RequestParam(value="year", required=false) Integer year,
            @RequestParam(value="month", required=false) Integer month) {
        List<LectureResult> lectures;
        try {
            if(userId != null) {
                lectures = lectureService.selectLecturesByUserId(userId);
            } else {
                lectures = lectureService.selectAllLectures(month, year);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(lectures, HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasPermission(null, 'MENTOR') OR hasPermission(null, 'ADMIN')")
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
    @PreAuthorize("hasPermission(#lectureId, 'Lecture', 'OWNER') OR hasPermission(null, 'ADMIN')")
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

    @Override
    @PreAuthorize("hasPermission(#commentId, 'Comment', 'OWNER') OR hasPermission(null, 'ADMIN')")
    public ResponseEntity<Void> deleteComment(@ApiParam(value = "Comment's ID", required = true) @PathVariable("comment-id") Integer commentId) {
        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            commentService.removeComment(userId, commentId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasPermission(#commentId, 'Comment', 'OWNER') OR hasPermission(null, 'ADMIN')")
    public ResponseEntity<Void> putComment(@ApiParam(value = "Comment's ID", required = true) @PathVariable("comment-id") Integer commentId, @ApiParam(value = "Comment's VO") @RequestBody(required = true) Comment comment) {

        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            commentService.updateComment(commentId, userId, comment);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
