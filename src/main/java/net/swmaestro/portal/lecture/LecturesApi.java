package net.swmaestro.portal.lecture;


import io.swagger.annotations.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Api(value = "lectures", description = "the lectures API")
public interface LecturesApi {

    @ApiOperation(value = "Delete Lecture", notes = "Delete a Lecture", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            @AuthorizationScope(scope = "mentor", description = "Mentor"),
            @AuthorizationScope(scope = "mentee", description = "Mentee")
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/lectures/{lecture-id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lectureId") Integer lectureId


    );


    @ApiOperation(value = "List Attachments of Lecture", notes = "Return attachments list of lecture.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/lectures/{lecture-id}/attachments",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Void> getAttachmentsOfLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lectureId") Integer lectureId


    );


    @ApiOperation(value = "List Comments of Lecture", notes = "Return comments list of lecture.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/lectures/{lecture-id}/comments",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Void> getCommentsOfLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lectureId") Integer lectureId


    );


    @ApiOperation(value = "Get Lecture", notes = "Returns a Lecture.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/lectures/{lecture-id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Void> getLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lectureId") Integer lectureId


    );


    @ApiOperation(value = "Lecture List", notes = "Return lectures list.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/lectures",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Void> getLectures();


    @ApiOperation(value = "Upload attachment on Lecture", notes = "Uploads a attachment on lecture.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/lectures/{lecture-id}/attachments",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> postAttachmentOfLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lectureId") Integer lectureId


    );


    @ApiOperation(value = "Create Comment on Lecture", notes = "Creates a comment on lecture.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/lectures/{lecture-id}/comments",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> postCommentOfLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lectureId") Integer lectureId


    );


    @ApiOperation(value = "Create Lecture", notes = "Creates a Lecture.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            @AuthorizationScope(scope = "mentor", description = "Mentor"),
            @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/lectures",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> postLecture();


    @ApiOperation(value = "Edit Lecture", notes = "Edit a Lecture", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            @AuthorizationScope(scope = "mentor", description = "Mentor"),
            @AuthorizationScope(scope = "mentee", description = "Mentee")
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/lectures/{lecture-id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> putLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lectureId") Integer lectureId


    );

}
