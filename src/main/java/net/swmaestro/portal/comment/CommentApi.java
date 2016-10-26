package net.swmaestro.portal.comment;


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

@Api(value = "comments", description = "the comments API")
public interface CommentApi {

    @ApiOperation(value = "Delete Comment", notes = "Delete a comment.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/comments/{comment-id}",
        produces = { "application/json" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteComment(
            @ApiParam(value = "Comment's ID", required = true) @PathVariable("commentId") Integer commentId


    );


    @ApiOperation(value = "Get Comment", notes = "Returns a comment.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/comments/{comment-id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Void> getComment(
            @ApiParam(value = "Comment's ID", required = true) @PathVariable("commentId") Integer commentId


    );


    @ApiOperation(value = "Edit Comment", notes = "Edit a comment.", response = Void.class, authorizations = {
        @Authorization(value = "smp_auth", scopes = {
            
            })
    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Succeed.", response = Void.class) })
    @RequestMapping(value = "/comments/{comment-id}",
        produces = { "application/json" }, 
        method = RequestMethod.PUT)
    ResponseEntity<Void> putComment(
            @ApiParam(value = "Comment's ID", required = true) @PathVariable("commentId") Integer commentId


    );

}
