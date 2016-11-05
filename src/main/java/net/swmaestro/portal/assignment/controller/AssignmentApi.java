package net.swmaestro.portal.assignment.controller;

import io.swagger.annotations.*;
import net.swmaestro.portal.assignment.vo.Assignment;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.lecture.vo.Lecture;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Api(value = "assignments", description = "the assignments API")
public interface AssignmentApi {

    @ApiOperation(value = "Delete Assignment", notes = "Deletes a Assignment.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/assignments/{assignment-id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteAssignment(
            @ApiParam(value = "Assignment's ID", required = true) @PathVariable("assignment-id") Integer assignmentId


    );


    @ApiOperation(value = "Assignment Profile", notes = "Returns assignment's profile.", response = Assignment.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Assignment Profile", response = Assignment.class) })
    @RequestMapping(value = "/assignments/{assignment-id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Assignment> getAssignment(
            @ApiParam(value = "Assignment's ID", required = true) @PathVariable("assignment-id") Integer assignmentId


    );


    @ApiOperation(value = "assignments List", notes = "Returns list of assignments.", response = Assignment.class, responseContainer = "List", authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "assignments List", response = Assignment.class) })
    @RequestMapping(value = "/assignments",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<Assignment>> getAssignments(
            @RequestParam(value="user", required=false) Integer user,
            @RequestParam(value="year", required=false) Integer year,
            @RequestParam(value="month", required=false) Integer month);


    @ApiOperation(value = "Create Assignment", notes = "Creates a new assignment (Sign Up).", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class),
        @ApiResponse(code = 400, message = "Bad request.", response = Void.class),
        @ApiResponse(code = 409, message = "Conflict.", response = Void.class) })
    @RequestMapping(value = "/assignments",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> postAssignment(

            @ApiParam(value = "Assignment's articleGenerationId") @RequestBody(required = true) Assignment assignment

    );

    @ApiOperation(value = "Edit Assignment", notes = "Edit assignment's profile.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/assignments/{assignment-id}",
        produces = { "application/json" },
        method = RequestMethod.PUT)
    ResponseEntity<Void> putAssignment(

            @ApiParam(value = "Assignment's ID", required = true) @PathVariable("assignment-id") Integer assignmentId
            ,

            @ApiParam(value = "Assignment's VO") @RequestBody(required = true) Assignment assignment
    );


    @ApiOperation(value = "comments List by assignmentId", notes = "Returns list of comments by assignmentId.", response = Comment.class, responseContainer = "List", authorizations = {
            @Authorization(value = "smp_auth", scopes = {
                    @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "comments List", response = Assignment.class) })
    @RequestMapping(value = "/assignments/{assignment-id}/comments",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Comment>> getCommentsByAssignmentId(  @ApiParam(value = "Assignment's ID", required = true) @PathVariable("assignment-id") Integer assignmentId
    );

    @ApiOperation(value = "Create Comment By Assignment Id", notes = "Create Comment By Assignment Id.", response = Void.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succeed.", response = Void.class),
            @ApiResponse(code = 400, message = "Bad request.", response = Void.class),
            @ApiResponse(code = 409, message = "Conflict.", response = Void.class) })
    @RequestMapping(value = "/assignments/{assignment-id}/comments",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> postCommentInAssignment(
            @ApiParam(value = "Assignment's ID", required = true) @PathVariable("assignment-id") Integer assignmentId,
            @ApiParam(value = "Comment") @RequestBody(required = true) Comment comment
    );

    @ApiOperation(value = "Delete Comment", notes = "Deletes a Comment.", response = Void.class, authorizations = {
            @Authorization(value = "smp_auth", scopes = {
                    @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/assignments/{assignment-id}/comments/{comment-id}",
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
    @RequestMapping(value = "/assignments/{assignment-id}/comments/{comment-id}",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> putComment(

            @ApiParam(value = "Comment's ID", required = true) @PathVariable("comment-id") Integer commentId
            ,
            @ApiParam(value = "Comment's VO") @RequestBody(required = true) Comment comment
    );

}
