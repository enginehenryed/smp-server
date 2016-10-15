package net.swmaestro.portal.attachment.controller;

import io.swagger.annotations.*;
import net.swmaestro.portal.attachment.vo.PostAttachmentResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Api(value = "attachment", description = "Attachment API")
public interface AttachmentApi {

    @ApiOperation(value = "Upload Attachment",
            notes = "Upload a new attachment.",
            response = PostAttachmentResponse.class,
            authorizations = { @Authorization(value = "smp_auth", scopes = {}) },
            tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Succeed.", response = Void.class),
            @ApiResponse(code = 400, message = "Bad request.", response = Void.class) })
    @RequestMapping(value = "/attachments",
            consumes = { "multipart/form-data" },
            produces = { "application/json" },
            method = RequestMethod.POST)
    ResponseEntity<PostAttachmentResponse> postAttachment(
            @ApiParam(value = "file") @RequestPart(value = "file", required = false) MultipartFile file
    ) throws Exception;


    @ApiOperation(value = "Download Attachment",
            notes = "Download attachment",
            response = Void.class,
            authorizations = { @Authorization(value = "smp_auth", scopes = {}) },
            tags={  })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Download Attachment", response = Void.class) })
    @RequestMapping(value = "/attachments/{attachment-id}",
            method = RequestMethod.GET)
    ResponseEntity<Void> getAttachment(
            @ApiParam(value = "Attachment ID", required = true) @PathVariable("attachment-id") int attachmentId
    );

}
