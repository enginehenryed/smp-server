package net.swmaestro.portal.assignment.controller;

import io.swagger.annotations.*;
import net.swmaestro.portal.assignment.vo.Assignment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Api(value = "assignments", description = "the assignments API")
public interface AssignmentsApi {

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
    ResponseEntity<List<Assignment>> getAssignments();


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

}
