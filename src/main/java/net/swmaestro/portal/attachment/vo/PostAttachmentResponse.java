package net.swmaestro.portal.attachment.vo;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by junha on 2016. 10. 15..
 */
public class PostAttachmentResponse {

    private int attachmentId;

    public PostAttachmentResponse(int attachmentId) {
        setAttachmentId(attachmentId);
    }

    /**
     * Attachment ID
     * @return attachmentId
     **/
    @ApiModelProperty(required = true, value = "Attachment ID")
    public int getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(int attachmentId) {
        this.attachmentId = attachmentId;
    }
}
