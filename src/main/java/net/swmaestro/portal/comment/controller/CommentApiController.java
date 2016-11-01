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


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Controller
public class CommentApiController implements CommentApi {

    @Resource(name = "commentService")
    private CommentService commentService;

    @Override
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