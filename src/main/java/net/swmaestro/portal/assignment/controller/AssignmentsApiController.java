package net.swmaestro.portal.assignment.controller;

import io.swagger.annotations.ApiParam;
import net.swmaestro.portal.assignment.service.AssignmentService;
import net.swmaestro.portal.assignment.vo.Assignment;
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
public class AssignmentsApiController implements AssignmentsApi {

    @Resource(name = "assignmentService")
    private AssignmentService assignmentService;
    
    @Resource(name = "commentService")
    private CommentService commentService;


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


    public ResponseEntity<Assignment> getAssignment(
            @ApiParam(value = "Assignment's ID", required = true) @PathVariable("assignment-id") Integer assignmentId


    ) {
        Assignment assignment;

        try {
            assignment = assignmentService.selectAssignment(assignmentId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Assignment>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<Assignment>(assignment, HttpStatus.OK);
    }

    public ResponseEntity<List<Assignment>> getAssignments() {
        List<Assignment> assignments;
        try {
            assignments = assignmentService.selectAllAssignments();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Assignment>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Assignment>>(assignments, HttpStatus.OK);
    }

    @Override
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
    public ResponseEntity<List<Comment>> getCommentsByAssignmentId(@ApiParam(value = "Assignment's ID", required = true) @PathVariable("assignment-id") Integer assignmentId) {
        List<Comment> comments;
        try {
            comments = commentService.selectCommentsByArticleId(assignmentId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Comment>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
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
}
