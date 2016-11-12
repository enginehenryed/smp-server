package net.swmaestro.portal.user.controller;

import net.swmaestro.portal.user.service.UserService;
import net.swmaestro.portal.user.vo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Controller
public class UserApiController implements UserApi {

    @Resource(name="userService")
    private UserService userService;

    public ResponseEntity<Void> deleteMe() {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PreAuthorize("hasPermission(null, 'ADMIN')")
    public ResponseEntity<Void> deleteUser(
        @PathVariable("userId") Integer userId
    ) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<User> getMe() {
        // do some magic!
        return new ResponseEntity<User>(HttpStatus.OK);
    }

    public ResponseEntity<User> getUser(
        @PathVariable("user-id") Integer userId
    ) {
        User user;

        try {
            user = userService.selectUser(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<User>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PreAuthorize("hasPermission(null, 'ADMIN')")
    public ResponseEntity<List<User>> getUsers(
            @RequestParam(value = "userEmail", required = false) String userEmail
    ) {
        return new ResponseEntity<List<User>>(HttpStatus.OK);
    }

    public ResponseEntity<Void> postUser(@RequestBody(required = true) User user) throws Exception {
        int user_id;
        try {
            user_id = userService.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally { }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> putMe(@RequestBody(required = true) User user) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PreAuthorize("hasPermission(null, 'ADMIN')")
    public ResponseEntity<Void> putUser(
            @PathVariable("userId") Integer userId,
            @RequestBody(required = true) User user
    ) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
