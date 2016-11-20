package net.swmaestro.portal.attachment.service;


import net.swmaestro.portal.attachment.vo.Attachment;
import org.springframework.web.multipart.MultipartFile;


public interface AttachmentService {

	Attachment getAttachment(final String attachmentId) throws Exception;

	String createAttachment(MultipartFile file, int attachmentWriterId) throws Exception;

}
