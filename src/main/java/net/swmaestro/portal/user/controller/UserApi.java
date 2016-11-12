package net.swmaestro.portal.user.controller;

import io.swagger.annotations.*;
import net.swmaestro.portal.assignment.vo.Assignment;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.lecture.vo.Lecture;
import net.swmaestro.portal.user.vo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Api(value = "users", description = "the users API")
public interface UserApi {

    @RequestMapping(value = "/users/me",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteMe();


    @RequestMapping(value = "/users/{user-id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUser(
            @PathVariable("userId") Integer userId
    );


    @RequestMapping(value = "/users/me",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<User> getMe();


    @RequestMapping(value = "/users/{user-id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<User> getUser(
            @PathVariable("userId") Integer userId
    );


    @RequestMapping(value = "/users",
        produces = { "application/json" },
        method = RequestMethod.GET)
    ResponseEntity<List<User>> getUsers() throws Exception;


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
    );


    @RequestMapping(value = "/users/{user-id}",
        consumes = { "application/json" },
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> putUser(
            @PathVariable("userId") Integer userId,
            @RequestBody(required = true) User user
    );

    @RequestMapping(value = "/users/me/lecture",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Lecture>> getMyLectures();

    @RequestMapping(value = "/users/me/assignment",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Assignment>> getMyAssignments();

    @RequestMapping(value = "/users/me/comment",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<Comment>> getMyComments();

}
