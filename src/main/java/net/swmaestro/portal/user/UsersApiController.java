package net.swmaestro.portal.user;

import io.swagger.annotations.*;

import net.swmaestro.portal.user.vo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Controller
public class UsersApiController implements UsersApi {

    public ResponseEntity<Void> deleteMe() {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteUser(
@ApiParam(value = "User's ID",required=true ) @PathVariable("userId") Integer userId


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<User> getMe() {
        // do some magic!
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    public ResponseEntity<User> getUser(
@ApiParam(value = "User's ID",required=true ) @PathVariable("userId") Integer userId


) {
        // do some magic!
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    public ResponseEntity<List<User>> getUsers(@ApiParam(value = "User's eamil to filter") @RequestParam(value = "userEmail", required = false) String userEmail



) {
        // do some magic!
        return new ResponseEntity<List<User>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> postUser(


@ApiParam(value = "User's eamil" ) @RequestPart(value="userEmail", required=false)  String userEmail
,
        


@ApiParam(value = "User's name" ) @RequestPart(value="userName", required=false)  String userName
,
        


@ApiParam(value = "User's password" ) @RequestPart(value="userPassword", required=false)  String userPassword
) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> putMe(


@ApiParam(value = "User's name" ) @RequestPart(value="userName", required=false)  String userName
,
        


@ApiParam(value = "User's password" ) @RequestPart(value="userPassword", required=false)  String userPassword
) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> putUser(
@ApiParam(value = "User's ID",required=true ) @PathVariable("userId") Integer userId


,
        


@ApiParam(value = "User's name" ) @RequestPart(value="userName", required=false)  String userName
,
        


@ApiParam(value = "User's password" ) @RequestPart(value="userPassword", required=false)  String userPassword
) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
