package net.swmaestro.portal.lecture;


import io.swagger.annotations.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Controller
public class LecturesApiController implements LecturesApi {

    public ResponseEntity<Void> deleteLecture(
@ApiParam(value = "Lecture's ID",required=true ) @PathVariable("lectureId") Integer lectureId


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> getAttachmentsOfLecture(
@ApiParam(value = "Lecture's ID",required=true ) @PathVariable("lectureId") Integer lectureId


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> getCommentsOfLecture(
@ApiParam(value = "Lecture's ID",required=true ) @PathVariable("lectureId") Integer lectureId


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> getLecture(
@ApiParam(value = "Lecture's ID",required=true ) @PathVariable("lectureId") Integer lectureId


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> getLectures() {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> postAttachmentOfLecture(
@ApiParam(value = "Lecture's ID",required=true ) @PathVariable("lectureId") Integer lectureId


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> postCommentOfLecture(
@ApiParam(value = "Lecture's ID",required=true ) @PathVariable("lectureId") Integer lectureId


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> postLecture() {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> putLecture(
@ApiParam(value = "Lecture's ID",required=true ) @PathVariable("lectureId") Integer lectureId


) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}
