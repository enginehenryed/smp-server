package net.swmaestro.portal.lecture.controller;

import io.swagger.annotations.*;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.lecture.vo.Lecture;
import net.swmaestro.portal.lecture.vo.LectureResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Api(value = "lectures", description = "the lectures API")
public interface LectureApi {

    @ApiOperation(value = "Delete Lecture", notes = "Deletes a Lecture.", response = Void.class, authorizations = {
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
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lecture-id") Integer lectureId
    );


    @ApiOperation(value = "Lecture Profile", notes = "Returns lecture's profile.", response = Lecture.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Lecture Profile", response = Lecture.class) })
    @RequestMapping(value = "/lectures/{lecture-id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<LectureResult> getLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lecture-id") Integer lectureId


    );


    @ApiOperation(value = "lectures List", notes = "Returns list of lectures.", response = Lecture.class, responseContainer = "List", authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "lectures List", response = Lecture.class) })
    @RequestMapping(value = "/lectures",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<LectureResult>> getLectures(
            @RequestParam(value="userId", required=false) Integer userId,
            @RequestParam(value="year", required=false) Integer year,
            @RequestParam(value="month", required=false) Integer month);


    @ApiOperation(value = "Create Lecture", notes = "Creates a new lecture (Sign Up).", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class),
        @ApiResponse(code = 400, message = "Bad request.", response = Void.class),
        @ApiResponse(code = 409, message = "Conflict.", response = Void.class) })
    @RequestMapping(value = "/lectures",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> postLecture(

            @ApiParam(value = "Lecture's articleGenerationId") @RequestBody(required = true) Lecture lecture

    );

    @ApiOperation(value = "Edit Lecture", notes = "Edit lecture's profile.", response = Void.class, authorizations = {
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

            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lecture-id") Integer lectureId
            ,

            @ApiParam(value = "Lecture's VO") @RequestBody(required = true) Lecture lecture
    );



    @ApiOperation(value = "comments List by lectureId", notes = "Returns list of comments by lectureId.", response = Comment.class, responseContainer = "List", authorizations = {
            @Authorization(value = "smp_auth", scopes = {
                    @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "comments List", response = Lecture.class) })
    @RequestMapping(value = "/lectures/{lecture-id}/comments",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Comment>> getCommentsByLectureId(  @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lecture-id") Integer lectureId
    );

    @ApiOperation(value = "Create Comment By Lecture Id", notes = "Create Comment By Lecture Id.", response = Void.class, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succeed.", response = Void.class),
            @ApiResponse(code = 400, message = "Bad request.", response = Void.class),
            @ApiResponse(code = 409, message = "Conflict.", response = Void.class) })
    @RequestMapping(value = "/lectures/{lecture-id}/comments",
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<Void> postCommentInLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lecture-id") Integer lectureId,
            @ApiParam(value = "Comment") @RequestBody(required = true) Comment comment
    );


    @ApiOperation(value = "Delete Comment", notes = "Deletes a Comment.", response = Void.class, authorizations = {
            @Authorization(value = "smp_auth", scopes = {
                    @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/lectures/{lecture-id}/comments/{comment-id}",
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
    @RequestMapping(value = "/lectures/{lecture-id}/comments/{comment-id}",
            produces = { "application/json" },
            method = RequestMethod.PUT)
    ResponseEntity<Void> putComment(

            @ApiParam(value = "Comment's ID", required = true) @PathVariable("comment-id") Integer commentId
            ,
            @ApiParam(value = "Comment's VO") @RequestBody(required = true) Comment comment
    );


}
