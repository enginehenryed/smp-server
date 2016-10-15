package net.swmaestro.portal.lecture.controller;

import io.swagger.annotations.ApiParam;
import net.swmaestro.portal.auth.TokenUtil;
import net.swmaestro.portal.lecture.service.LectureService;
import net.swmaestro.portal.lecture.vo.Lecture;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.token.Token;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

@Controller
public class LecturesApiController implements LecturesApi {

    @Resource(name = "lectureService")
    private LectureService lectureService;

    public ResponseEntity<Void> deleteLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lecture-id") Integer lectureId


    ) {
        try {
            lectureService.deleteLecture(lectureId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }

        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    public ResponseEntity<Lecture> getLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lecture-id") Integer lectureId


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

    @Override
    public ResponseEntity<Void> postLecture(@ApiParam(value = "token of who posts Lecture") @RequestHeader(value = "Authorization", required = true) String authorizationHeader, @ApiParam(value = "Lecture's articleGenerationId") @RequestParam(value = "articleGenerationId", required = true) Integer articleGenerationId, @ApiParam(value = "Lecture's articleSubject") @RequestParam(value = "articleSubject", required = true) String articleSubject, @ApiParam(value = "Lecture's articleContent") @RequestParam(value = "articleContent", required = true) String articleContent, @ApiParam(value = "Lecture's articleTeacherId") @RequestParam(value = "lectureTeacherId", required = true) Integer lectureTeacherId, @ApiParam(value = "Lecture's articleBeginAt") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(value = "lectureBeginAt", required = true) Date lectureBeginAt, @ApiParam(value = "Lecture's articleEndAt") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") @RequestParam(value = "lectureEndAt", required = true) Date lectureEndAt) {
        try {
            String token = authorizationHeader.substring(7);
            Integer userId = TokenUtil.parse(token);
            lectureService.insertLecture(token, articleGenerationId, articleSubject, articleContent,
                    lectureTeacherId, lectureBeginAt, lectureEndAt);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
        } finally {
        }
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<Void> putLecture(
            @ApiParam(value = "Lecture's ID", required = true) @PathVariable("lectureId") Integer lectureId


            ,


            @ApiParam(value = "Lecture's name") @RequestParam(value = "lectureName", required = false) String lectureName
            ,


            @ApiParam(value = "Lecture's password") @RequestParam(value = "lecturePassword", required = false) String LlcturePassword
    ) {
        // do some magic!
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
}
