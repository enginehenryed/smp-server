package net.swmaestro.portal.attachment.controller;

import io.swagger.annotations.ApiParam;
import net.swmaestro.portal.attachment.service.AttachmentService;
import net.swmaestro.portal.attachment.util.AttachmentUtil;
import net.swmaestro.portal.attachment.vo.Attachment;
import net.swmaestro.portal.attachment.vo.PostAttachmentResponse;
import net.swmaestro.portal.auth.JWTAuthentication;
import net.swmaestro.portal.common.exception.NotFoundException;
import net.swmaestro.portal.common.exception.UnexpectedException;
import net.swmaestro.portal.user.vo.User;
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
import java.io.File;
import java.io.UnsupportedEncodingException;
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
        User user = authentication.getUser();

        int attachmentId = attachmentService.createAttachment(file, user.getUserId());

        return new ResponseEntity<>(
                new PostAttachmentResponse(attachmentId),
                HttpStatus.CREATED
        );
    }

    @Override
    public ResponseEntity<FileSystemResource> getAttachment(
            @ApiParam(value = "Attachment ID", required = true) @PathVariable("attachment-id") int attachmentId
    ) {
        Attachment attachment;
        try {
            attachment = attachmentService.getAttachment(attachmentId);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UnexpectedException();
        }

        if (attachment == null) {
            throw new NotFoundException();
        }

        String depositeFilename;
        HttpHeaders responseHeaders = new HttpHeaders();
        try {
            depositeFilename = URLEncoder.encode(attachment.getAttachmentName(), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            depositeFilename = String.format("%s.%s",
                    attachment.getAttachmentId(), attachment.getAttachmentExtension());
        }
        responseHeaders.set("Content-Disposition", String.format("attachment; filename=\"%s\"", depositeFilename));
        responseHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<>(
                AttachmentUtil.getFileSystemResource(attachment.getAttachmentUrl()),
                responseHeaders,
                HttpStatus.OK
        );
    }
}
