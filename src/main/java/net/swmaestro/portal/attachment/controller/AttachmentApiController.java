package net.swmaestro.portal.attachment.controller;

import io.swagger.annotations.ApiParam;
import net.swmaestro.portal.attachment.service.AttachmentService;
import net.swmaestro.portal.attachment.vo.Attachment;
import net.swmaestro.portal.attachment.vo.PostAttachmentResponse;
import net.swmaestro.portal.auth.JWTAuthentication;
import net.swmaestro.portal.user.vo.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;


@Controller
public class AttachmentApiController implements AttachmentApi {

    @Resource(name="attachmentService")
    private AttachmentService attachmentService;

    @Override
    public ResponseEntity<PostAttachmentResponse> postAttachment(
            @ApiParam(value = "file") @RequestPart(value = "file", required = false) MultipartFile file
    ) throws Exception {

        JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
        User user = authentication.getUser();

        int attachmentId = attachmentService.createAttachment(file, user.getUserId());

        return new ResponseEntity<>(
                new PostAttachmentResponse(attachmentId),
                HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<Void> getAttachment(
            @ApiParam(value = "Attachment ID", required = true) @PathVariable("attachment-id") int attachmentId
    ) {
        Attachment attachment;
        try {
            attachment = attachmentService.getAttachment(attachmentId);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

        if (attachment == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // TODO: Download File
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
