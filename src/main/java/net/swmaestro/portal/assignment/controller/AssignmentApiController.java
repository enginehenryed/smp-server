package net.swmaestro.portal.assignment.controller;

import io.swagger.annotations.ApiParam;
import net.swmaestro.portal.assignment.service.AssignmentService;
import net.swmaestro.portal.assignment.vo.Assignment;
import net.swmaestro.portal.assignment.vo.AssignmentResult;
import net.swmaestro.portal.auth.JWTAuthentication;
import net.swmaestro.portal.comment.service.CommentService;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.comment.vo.CommentResult;
import net.swmaestro.portal.user.vo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Controller
public class AssignmentApiController implements AssignmentApi {

    @Resource(name = "assignmentService")
    private AssignmentService assignmentService;
    
    @Resource(name = "commentService")
    private CommentService commentService;

    @PreAuthorize("hasPermission(#assignmentId, 'Assignment', 'OWNER') OR hasPermission(null, 'ADMIN')")
    public ResponseEntity<Void> deleteAssignment(
            @ApiParam(value = "Assignment's ID", required = true) @PathVariable("assignment-id") Integer assignmentId


    ) {
        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            assignmentService.removeAssignment(userId, assignmentId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    public ResponseEntity<AssignmentResult> getAssignment(
            @ApiParam(value = "Assignment's ID", required = true) @PathVariable("assignment-id") Integer assignmentId


    ) throws Exception {
        AssignmentResult assignment;
        assignment = assignmentService.selectAssignment(assignmentId);

        return new ResponseEntity<>(assignment, HttpStatus.OK);
    }

    public ResponseEntity<List<AssignmentResult>> getAssignments(
            @RequestParam(value="userId", required=false) Integer userId,
            @RequestParam(value="year", required=false) Integer year,
            @RequestParam(value="month", required=false) Integer month
    ) throws Exception {
        List<AssignmentResult> assignments;
        if(userId != null) {
            assignments = assignmentService.selectAssignmentsByUserId(userId);
        } else {
            assignments = assignmentService.selectAllAssignments(month, year);
        }
        return new ResponseEntity<>(assignments, HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasPermission(null, 'MENTOR') OR hasPermission(null, 'ADMIN')")
    public ResponseEntity<Void> postAssignment(@ApiParam(value = "Assignment's articleGenerationId") @RequestBody(required = true) Assignment assignment) {
        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            assignmentService.insertAssignment(userId, assignment);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @Override
    @PreAuthorize("hasPermission(#assignmentId, 'Assignment', 'OWNER') OR hasPermission(null, 'ADMIN')")
    public ResponseEntity<Void> putAssignment(@ApiParam(value = "Assignment's ID", required = true) @PathVariable("assignment-id") Integer assignmentId,
                                           @ApiParam(value = "Assignment's VO") @RequestBody(required = true) Assignment assignment) {

        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            assignmentService.updateAssignment(assignmentId, userId, assignment);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @Override
    public ResponseEntity<List<CommentResult>> getCommentsByAssignmentId(@ApiParam(value = "Assignment's ID", required = true) @PathVariable("assignment-id") Integer assignmentId) {
        List<CommentResult> comments;
        try {
            comments = commentService.selectCommentsByArticleId(assignmentId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<CommentResult>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<CommentResult>>(comments, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> postCommentInAssignment(@ApiParam(value = "Assignment's ID", required = true) @PathVariable("assignment-id") Integer assignmentId, @ApiParam(value = "Comment") @RequestBody(required = true) Comment comment) {
        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            User user = authentication.getUser();
            Integer userId = user.getUserId();
            commentService.insertCommentInArticle(assignmentId, userId, comment);
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
