package net.swmaestro.portal.attachment.service;


import net.swmaestro.portal.attachment.dao.AttachmentDAO;
import net.swmaestro.portal.attachment.util.AttachmentUtil;
import net.swmaestro.portal.attachment.vo.Attachment;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service("attachmentService")
public class AttachmentServiceImpl implements AttachmentService {
	Logger log = Logger.getLogger(this.getClass());

	@Resource(name="attachmentDAO")
	private AttachmentDAO attachmentDAO;

	@Override
	public Attachment getAttachment(int attachmentId) throws Exception {
		Map<String, Object> map = new HashMap<>();
		map.put("attachmentId", attachmentId);

		return attachmentDAO.selectAttachment(map);
	}

	@Override
	public int createAttachment(MultipartFile file, int attachmentWriterId) throws Exception {
		String fileName = file.getOriginalFilename();
		String fileExtension, storedFileName;

		if (fileName.contains(".")) {
			fileExtension = fileName.substring(fileName.lastIndexOf(".") + 1);
		} else {
			fileExtension = "";
		}

		// Store file.
		try {
			storedFileName = AttachmentUtil.storeFile(file, fileExtension);
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		}

		// Create Attachment row in DB.
		Attachment attachment = new Attachment();
		attachment.setAttachmentUrl(storedFileName);
		attachment.setAttachmentName(fileName);
		attachment.setAttachmentExtension(fileExtension);
		attachment.setAttachmentSize(file.getSize());
		attachment.setAttachmentType("");  // FIXME: 2016. 10. 15.
		attachment.setAttachmentWriterId(attachmentWriterId);
		attachmentDAO.insertAttachment(attachment);

		return attachment.getAttachmentId();
	}
}
