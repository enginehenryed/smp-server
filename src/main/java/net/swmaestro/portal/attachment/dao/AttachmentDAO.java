package net.swmaestro.portal.attachment.dao;


import net.swmaestro.portal.attachment.vo.Attachment;
import net.swmaestro.portal.common.dao.AbstractDAO;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;


@Repository("attachmentDAO")
public class AttachmentDAO extends AbstractDAO{

	public int insertAttachment(Attachment attachment) throws Exception {
		return (int) insert("attachment.insertAttachment", attachment);
	}

	public int insertAttachment(Map<String, Object> map) throws Exception {
		return (int) insert("attachment.insertAttachment", map);
	}

	@SuppressWarnings("unchecked")
	public Attachment selectAttachment(Map<String, Object> map) throws Exception{
		return (Attachment) selectOne("attachment.selectAttachment", map);
	}

	public int insertArticleAttachments(List<Map<String, Object>> mapsList) throws Exception {
		return (int) insert("attachment.insertArticleAttachments", mapsList);
	}

	public int removeArticleAttachments(Map<String, Object> map) throws Exception {
		return (int) delete("attachment.deleteArticleAttachments", map);
	}

}
