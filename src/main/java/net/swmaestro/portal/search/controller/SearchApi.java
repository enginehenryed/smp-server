package net.swmaestro.portal.search.controller;

import io.swagger.annotations.*;
import net.swmaestro.portal.comment.vo.Comment;
import net.swmaestro.portal.user.vo.UserResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Api(value = "search", description = "the search API")
public interface SearchApi {

    @RequestMapping(value = "/search/all",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<Map> getAll(
            @RequestParam(value="q", required=true) String query
    );

    @RequestMapping(value = "/search/users",
            produces = { "application/json" },
            method = RequestMethod.GET)
    ResponseEntity<List<UserResult>> getUsers(
            @RequestParam(value="q", required=true) String query
    );

}
