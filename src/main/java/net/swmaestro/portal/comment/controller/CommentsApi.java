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
    @RequestMapping(value = "/lectures/{lecture-id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteLecture(
            @ApiParam(value = "Comment's ID", required = true) @PathVariable("lecture-id") Integer lectureId


    );


    @ApiOperation(value = "Comment Profile", notes = "Returns lecture's profile.", response = Comment.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Comment Profile", response = Comment.class) })
    @RequestMapping(value = "/lectures/{lecture-id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Comment> getLecture(
            @ApiParam(value = "Comment's ID", required = true) @PathVariable("lecture-id") Integer lectureId


    );


    @ApiOperation(value = "lectures List", notes = "Returns list of lectures.", response = Comment.class, responseContainer = "List", authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "lectures List", response = Comment.class) })
    @RequestMapping(value = "/lectures",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Comment>> getLectures();


    @ApiOperation(value = "Create Comment", notes = "Creates a new comment (Sign Up).", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class),
        @ApiResponse(code = 400, message = "Bad request.", response = Void.class),
        @ApiResponse(code = 409, message = "Conflict.", response = Void.class) })
    @RequestMapping(value = "/lectures",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> postLecture(

            @ApiParam(value = "Comment's articleGenerationId") @RequestBody(required = true) Comment comment

    );

    @ApiOperation(value = "Edit Comment", notes = "Edit comment's profile.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/lectures/{lecture-id}",
        produces = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> putLecture(

            @ApiParam(value = "Comment's ID", required = true) @PathVariable("lecture-id") Integer lectureId
            ,

            @ApiParam(value = "Comment's VO") @RequestBody(required = true) Comment comment
    );

}
