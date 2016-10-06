package net.swmaestro.portal.lecture.controller;

import io.swagger.annotations.*;
import net.swmaestro.portal.lecture.vo.Lecture;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Api(value = "lectures", description = "the lectures API")
public interface LecturesApi {

    @ApiOperation(value = "Delete Me", notes = "Deletes Me (Leave).", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/lectures/me",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteMe();


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
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lectureId") Integer lectureId


    );


    @ApiOperation(value = "My Profile", notes = "Returns logined lecture's profile.", response = Lecture.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Lecture Response", response = Lecture.class) })
    @RequestMapping(value = "/lectures/me",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Lecture> getMe();


    @ApiOperation(value = "Lecture Profile", notes = "Returns lecture's profile.", response = Lecture.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Lecture Profile", response = Lecture.class) })
    @RequestMapping(value = "/lectures/{lecture-id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Lecture> getLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lectureId") Integer lectureId


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
    ResponseEntity<List<Lecture>> getLectures();


    @ApiOperation(value = "Create Lecture", notes = "Creates a new lecture (Sign Up).", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class),
        @ApiResponse(code = 400, message = "Bad request.", response = Void.class),
        @ApiResponse(code = 409, message = "Conflict.", response = Void.class) })
    @RequestMapping(value = "/lectures",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> postLecture(


            @ApiParam(value = "Lecture's eamil") @RequestPart(value = "lectureEmail", required = false) String lectureEmail
            ,


            @ApiParam(value = "Lecture's name") @RequestPart(value = "lectureName", required = false) String lectureName
            ,


            @ApiParam(value = "Lecture's password") @RequestPart(value = "lecturePassword", required = false) String lecturePassword
    );


    @ApiOperation(value = "Edit Me", notes = "Edit my profile.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/lectures/me",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> putMe(


            @ApiParam(value = "Lecture's name") @RequestPart(value = "lectureName", required = false) String lectureName
            ,


            @ApiParam(value = "Lecture's password") @RequestPart(value = "lecturePassword", required = false) String lecturePassword
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
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lectureId") Integer lectureId


            ,


            @ApiParam(value = "Lecture's name") @RequestPart(value = "lectureName", required = false) String lectureName
            ,


            @ApiParam(value = "Lecture's password") @RequestPart(value = "lecturePassword", required = false) String lecturePassword
    );

}
