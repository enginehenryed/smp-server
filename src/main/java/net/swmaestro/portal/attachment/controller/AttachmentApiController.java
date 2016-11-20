package net.swmaestro.portal.attachment.controller;

import io.swagger.annotations.ApiParam;
import net.swmaestro.portal.attachment.service.AttachmentService;
import net.swmaestro.portal.attachment.util.AttachmentUtil;
import net.swmaestro.portal.attachment.vo.Attachment;
import net.swmaestro.portal.attachment.vo.PostAttachmentResponse;
import net.swmaestro.portal.auth.JWTAuthentication;
import net.swmaestro.portal.common.exception.NotFoundException;
import net.swmaestro.portal.common.exception.UnexpectedException;
import net.swmaestro.portal.user.vo.UserResult;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.net.URLEncoder;


@Controller
public class AttachmentApiController implements AttachmentApi {

    @Resource(name="attachmentService")
    private AttachmentService attachmentService;

    @Override
    public ResponseEntity<PostAttachmentResponse> postAttachment(
            @ApiParam(value = "file") @RequestPart(value = "file", required = false) MultipartFile file
    ) throws Exception {

        JWTAuthentication authentication = (JWTAuthentication) SecurityContextHolder.getContext().getAuthentication();
        UserResult user = authentication.getUser();

        String attachmentId = attachmentService.createAttachment(file, user.getUserId());

        return new ResponseEntity<>(
                new PostAttachmentResponse(attachmentId),
                HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<FileSystemResource> getAttachment(
            @ApiParam(value = "Attachment ID", required = true) @PathVariable("attachment-id") String attachmentId
    ) throws Exception {
        Attachment attachment;
        try {
            attachment = attachmentService.getAttachment(attachmentId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnexpectedException("Unexpected Exception");
        }

        if (attachment == null) {
            throw new NotFoundException("Attachment not found");
        }

        HttpHeaders responseHeaders = new HttpHeaders();

        if (attachment.getAttachmentType() != null && attachment.getAttachmentType().length() > 0) {
            responseHeaders.set("Content-Type", attachment.getAttachmentType());
        } else {
            responseHeaders.set("Content-Type", "application/octet-stream");
        }
        responseHeaders.set("Content-Disposition", "attachment; filename*=UTF-8''" + URLEncoder.encode(attachment.getAttachmentName(), "UTF-8"));
        responseHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<>(
                AttachmentUtil.getFileSystemResource(attachment.getAttachmentUrl()),
                responseHeaders,
                HttpStatus.OK
        );
    }
}
