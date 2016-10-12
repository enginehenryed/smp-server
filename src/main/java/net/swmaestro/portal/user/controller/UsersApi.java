package net.swmaestro.portal.user.controller;

import io.swagger.annotations.*;
import net.swmaestro.portal.user.vo.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Api(value = "users", description = "the users API")
public interface UsersApi {

    @ApiOperation(value = "Delete Me", notes = "Deletes Me (Leave).", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/users/me",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteMe();


    @ApiOperation(value = "Delete User", notes = "Deletes a User.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/users/{user-id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteUser(
            @ApiParam(value = "User's ID", required = true) @PathVariable("userId") Integer userId


    );


    @ApiOperation(value = "My Profile", notes = "Returns logined user's profile.", response = User.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "User Response", response = User.class) })
    @RequestMapping(value = "/users/me",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<User> getMe();


    @ApiOperation(value = "User Profile", notes = "Returns user's profile.", response = User.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "User Profile", response = User.class) })
    @RequestMapping(value = "/users/{user-id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<User> getUser(
            @ApiParam(value = "User's ID", required = true) @PathVariable("userId") Integer userId


    );


    @ApiOperation(value = "Users List", notes = "Returns list of users.", response = User.class, responseContainer = "List", authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Users List", response = User.class) })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<List<User>> getUsers(@ApiParam(value = "User's eamil to filter", example = "soma@naver.com") @RequestParam(value = "userEmail", required = false) String userEmail


    );


    @ApiOperation(value = "Create User", notes = "Creates a new user (Sign Up).", response = Void.class, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class),
        @ApiResponse(code = 400, message = "Bad request.", response = Void.class),
        @ApiResponse(code = 409, message = "Conflict.", response = Void.class) })
    @RequestMapping(value = "/users",
        produces = { "application/json" }, 
        method = RequestMethod.POST)
    ResponseEntity<Void> postUser(


            @ApiParam(value = "User's eamil") @RequestParam(required = false) String userEmail
            ,


            @ApiParam(value = "User's name") @RequestParam(required = false) String userName
            ,


            @ApiParam(value = "User's password") @RequestParam(required = false) String userPassword
    ) throws Exception;


    @ApiOperation(value = "Edit Me", notes = "Edit my profile.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/users/me",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> putMe(


            @ApiParam(value = "User's name") @RequestBody(required = false) String userName
            ,


            @ApiParam(value = "User's password") @RequestBody(required = false) String userPassword
    );


    @ApiOperation(value = "Edit User", notes = "Edit user's profile.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            @AuthorizationScope(scope = "manager", description = "Manager")
            })
    }, tags={  })
    @ApiResponses(value = {
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/users/{user-id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> putUser(
            @ApiParam(value = "User's ID", required = true) @PathVariable("userId") Integer userId


            ,


            @ApiParam(value = "User's name") @RequestBody(required = false) String userName
            ,


            @ApiParam(value = "User's password") @RequestBody(required = false) String userPassword
    );

}
