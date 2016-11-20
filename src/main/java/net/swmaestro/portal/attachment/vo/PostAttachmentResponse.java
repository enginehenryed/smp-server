package net.swmaestro.portal.attachment.vo;

/**
 * Created by junha on 2016. 10. 15..
 */
public class PostAttachmentResponse {

    private String attachmentId;

    public PostAttachmentResponse(String attachmentId) {
        setAttachmentId(attachmentId);
    }

    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }
}
