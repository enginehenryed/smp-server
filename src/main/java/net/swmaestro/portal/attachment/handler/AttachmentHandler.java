package net.swmaestro.portal.attachment.handler;

import net.swmaestro.portal.attachment.vo.Attachment;

/**
 * Created by junha on 2016. 11. 20..
 */
public interface AttachmentHandler {

    Attachment getAttachment(String attachmentId) throws Exception;

}
