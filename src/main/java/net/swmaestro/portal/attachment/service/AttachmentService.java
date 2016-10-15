package net.swmaestro.portal.attachment.service;


import net.swmaestro.portal.attachment.vo.Attachment;
import org.springframework.web.multipart.MultipartFile;


public interface AttachmentService {

	Attachment getAttachment(final int attachmentId) throws Exception;

	int createAttachment(MultipartFile file, int attachmentWriterId) throws Exception;

}
