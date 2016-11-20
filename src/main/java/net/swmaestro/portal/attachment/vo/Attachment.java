package net.swmaestro.portal.attachment.vo;

import io.swagger.annotations.ApiModelProperty;


/**
 * Attachment
 */

public class Attachment   {
    private String attachmentId;
    private String attachmentUrl;
    private String attachmentName;
    private String attachmentExtension;
    private long attachmentSize;
    private String attachmentType;
    private int attachmentWriterId;
    private int attachmentModifierId;

    /**
     * Attachment ID
     * @return attachmentId
     **/
    @ApiModelProperty(value = "Attachment ID")
    public String getAttachmentId() {
        return attachmentId;
    }

    public void setAttachmentId(String attachmentId) {
        this.attachmentId = attachmentId;
    }

    /**
     * Attachment URL
     * @return attachmentUrl
     **/
    @ApiModelProperty(value = "Attachment URL")
    public String getAttachmentUrl() {
        return attachmentUrl;
    }

    public void setAttachmentUrl(String attachmentUrl) {
        this.attachmentUrl = attachmentUrl;
    }

    /**
     * Attachment Name
     * @return attachmentName
     **/
    @ApiModelProperty(value = "Attachment Name")
    public String getAttachmentName() {
        return attachmentName;
    }

    public void setAttachmentName(String attachmentName) {
        this.attachmentName = attachmentName;
    }

    /**
     * Attachment Extension
     * @return attachmentExtension
     **/
    @ApiModelProperty(value = "Attachment Extension")
    public String getAttachmentExtension() {
        return attachmentExtension;
    }

    public void setAttachmentExtension(String attachmentExtension) {
        this.attachmentExtension = attachmentExtension;
    }

    /**
     * Attachment Size
     * @return attachmentSize
     **/
    @ApiModelProperty(value = "Attachment Size")
    public long getAttachmentSize() {
        return attachmentSize;
    }

    public void setAttachmentSize(long attachmentSize) {
        this.attachmentSize = attachmentSize;
    }

    /**
     * Attachment Type
     * @return attachmentType
     **/
    @ApiModelProperty(value = "Attachment Type")
    public String getAttachmentType() {
        return attachmentType;
    }

    public void setAttachmentType(String attachmentType) {
        this.attachmentType = attachmentType;
    }

    /**
     * Attachment Writer ID
     * @return attachmentWriterId
     **/
    @ApiModelProperty(value = "Attachment Writer ID")
    public int getAttachmentWriterId() {
        return attachmentWriterId;
    }

    public void setAttachmentWriterId(int attachmentWriterId) {
        this.attachmentWriterId = attachmentWriterId;
    }

    /**
     * Attachment Modifier ID
     * @return attachmentModifierId
     **/
    @ApiModelProperty(value = "Attachment Modifier ID")
    public int getAttachmentModifierId() {
        return attachmentModifierId;
    }

    public void setAttachmentModifierId(int attachmentModifierId) {
        this.attachmentModifierId = attachmentModifierId;
    }
}

