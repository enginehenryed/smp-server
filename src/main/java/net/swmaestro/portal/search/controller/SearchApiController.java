package net.swmaestro.portal.search.controller;

import net.swmaestro.portal.auth.JWTAuthentication;
import net.swmaestro.portal.search.service.SearchService;
import net.swmaestro.portal.user.vo.UserResult;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Controller
public class SearchApiController implements SearchApi {

    @Resource(name = "searchService")
    private SearchService searchService;

    @Override
    public ResponseEntity<Map> getAll(@RequestParam(value = "q", required = true) String query) {
        Map result = null;
        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            UserResult user = authentication.getUser();
            Integer userId = user.getUserId();
            result = searchService.selectAll(userId, query);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Map>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<Map>(result, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<List<UserResult>> getUsers(@RequestParam(value = "q", required = true) String query) {
        List<UserResult> result = null;
        try {
            JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
            UserResult user = authentication.getUser();
            Integer userId = user.getUserId();
            result = searchService.selectUsers(userId, query);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<UserResult>>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<List<UserResult>>(result, HttpStatus.OK);
    }
}