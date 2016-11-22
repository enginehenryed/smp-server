package net.swmaestro.portal.attachment.handler;

import net.swmaestro.portal.attachment.vo.Attachment;

import java.util.List;

/**
 * Created by junha on 2016. 11. 20..
 */
public interface AttachmentHandler {

    Attachment getAttachment(String attachmentId) throws Exception;

    int removeArticleAttachments(long articleId) throws Exception;

    int insertArticleAttachments(long articleId, List<String> attachmentIds) throws Exception;
}
