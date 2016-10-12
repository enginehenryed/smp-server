package net.swmaestro.portal.lecture.controller;

import io.swagger.annotations.ApiParam;
import net.swmaestro.portal.lecture.service.LectureService;
import net.swmaestro.portal.lecture.vo.Lecture;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Controller
public class LecturesApiController implements LecturesApi {

    @Resource(name="lectureService")
    private LectureService lectureService;

    public ResponseEntity<Void> deleteLecture(
            @ApiParam(value = "Lecture's ID",required=true ) @PathVariable("lecture-Id") Integer lectureId


    ) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Lecture> getMe() {
        // do some magic!
        return new ResponseEntity<Lecture>(HttpStatus.OK);
    }

    public ResponseEntity<Lecture> getLecture(
            @ApiParam(value = "Lecture's ID",required=true ) @PathVariable("lecture-id") Integer lectureId


    ) {
        Lecture lecture;

        try {
            lecture = lectureService.selectLecture(lectureId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Lecture>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<Lecture>(lecture, HttpStatus.OK);
    }

    public ResponseEntity<List<Lecture>> getLectures() {
        List<Lecture> lectures;
        try {
            lectures = lectureService.selectAllLectures();
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<List<Lecture>>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<List<Lecture>>(lectures, HttpStatus.OK);
    }

    public ResponseEntity<Void> postLecture(


            @ApiParam(value = "Lecture's eamil" ) @RequestPart(value="lectureEmail", required=false)  String lectureEmail
            ,



            @ApiParam(value = "Lecture's name" ) @RequestPart(value="lectureName", required=false)  String lectureName
            ,



            @ApiParam(value = "Lecture's password" ) @RequestPart(value="lecturePassword", required=false)  String lecturePassword
    ) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> putMe(


            @ApiParam(value = "Lecture's name" ) @RequestPart(value="lectureName", required=false)  String lectureName
            ,



            @ApiParam(value = "Lecture's password" ) @RequestPart(value="lecturePassword", required=false)  String lecturePassword
    ) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> putLecture(
            @ApiParam(value = "Lecture's ID",required=true ) @PathVariable("lectureId") Integer lectureId


            ,



            @ApiParam(value = "Lecture's name" ) @RequestPart(value="lectureName", required=false)  String lectureName
            ,



            @ApiParam(value = "Lecture's password" ) @RequestPart(value="lecturePassword", required=false)  String LlcturePassword
    ) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
