package net.swmaestro.portal.comment.controller;

import io.swagger.annotations.*;
import net.swmaestro.portal.comment.vo.Comment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Api(value = "comments", description = "the comments API")
public interface CommentsApi {

    @ApiOperation(value = "Delete Comment", notes = "Deletes a Comment.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/comments/{comment-id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteComment(
            @ApiParam(value = "Comment's ID", required = true) @PathVariable("comment-id") Integer commentId


    );

    @ApiOperation(value = "Edit Comment", notes = "Edit comment's profile.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/comments/{comment-id}",
        produces = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> putComment(

            @ApiParam(value = "Comment's ID", required = true) @PathVariable("comment-id") Integer commentId
            ,
            @ApiParam(value = "Comment's VO") @RequestBody(required = true) Comment comment
    );

}
