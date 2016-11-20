package net.swmaestro.portal.user.controller;

import io.swagger.annotations.*;
import net.swmaestro.portal.assignment.vo.AssignmentResult;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.lecture.vo.LectureResult;
import net.swmaestro.portal.user.vo.User;
import net.swmaestro.portal.user.vo.UserResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Api(value = "users", description = "the users API")
public interface UserApi {

    @RequestMapping(value = "/users/me",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteMe() throws Exception;


    @RequestMapping(value = "/users/{user-id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUser(
            @PathVariable("user-id") Integer userId
    ) throws Exception;


    @RequestMapping(value = "/users/me",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<UserResult> getMe() throws Exception;


    @RequestMapping(value = "/users/{user-id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<UserResult> getUser(
            @PathVariable("user-id") Integer userId
    ) throws Exception;


    @RequestMapping(value = "/users",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<UserResult>> getUsers() throws Exception;


    @RequestMapping(value = "/users",
        consumes = { "application/json" },
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> postUser(
            @RequestBody(required = true) User user
    ) throws Exception;


    @RequestMapping(value = "/users/me",
        consumes = { "application/json" },
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> putMe(
            @RequestBody(required = false) User user
    ) throws Exception;


    @RequestMapping(value = "/users/{user-id}",
        consumes = { "application/json" },
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> putUser(
            @PathVariable("user-id") Integer userId,
            @RequestBody(required = true) User user
    ) throws Exception;

    @RequestMapping(value = "/users/me/lectures",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<LectureResult>> getMyLectures() throws Exception;

    @RequestMapping(value = "/users/me/assignments",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<AssignmentResult>> getMyAssignments() throws Exception;

    @RequestMapping(value = "/users/me/comments",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Comment>> getMyComments() throws Exception;

}
