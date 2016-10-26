package net.swmaestro.portal.comment;


import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Controller
public class CommentApiController implements CommentApi {

    public ResponseEntity<Void> deleteComment(
@ApiParam(value = "Comment's ID",required=true ) @PathVariable("commentId") Integer commentId


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> getComment(
@ApiParam(value = "Comment's ID",required=true ) @PathVariable("commentId") Integer commentId


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> putComment(
@ApiParam(value = "Comment's ID",required=true ) @PathVariable("commentId") Integer commentId


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
