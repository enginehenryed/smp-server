package net.swmaestro.portal.user.controller;

import io.swagger.annotations.*;

import net.swmaestro.portal.user.service.UserService;
import net.swmaestro.portal.user.vo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Controller
public class UsersApiController implements UsersApi {

    @Resource(name="userService")
    private UserService userService;

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
@ApiParam(value = "User's ID",required=true ) @PathVariable("user-id") Integer userId


) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_id", userId);

        User user;

        try {
            user = userService.selectUser(map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    public ResponseEntity<List<User>> getUsers(@ApiParam(value = "User's eamil to filter") @RequestParam(value = "userEmail", required = false) String userEmail



) {
        return new ResponseEntity<List<User>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> postUser(@ApiParam(value = "User's eamil" ) @RequestParam(required=false)  String userEmail,
                                         @ApiParam(value = "User's name" ) @RequestParam(required=false)  String userName,
                                         @ApiParam(value = "User's password" ) @RequestParam(required=false)  String userPassword
    ) throws Exception {
        int user_id;
        try {
            user_id = userService.insertUser(userEmail, userPassword, userName);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally { }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> putMe(


@ApiParam(value = "User's name" ) @RequestParam(required=false)  String userName
,
        


@ApiParam(value = "User's password" ) @RequestParam(required=false)  String userPassword
) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> putUser(
@ApiParam(value = "User's ID",required=true ) @PathVariable("userId") Integer userId


,
        


@ApiParam(value = "User's name" ) @RequestParam(required=false)  String userName
,
        


@ApiParam(value = "User's password" ) @RequestParam(required=false)  String userPassword
) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
