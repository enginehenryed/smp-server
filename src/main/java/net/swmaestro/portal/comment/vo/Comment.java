package net.swmaestro.portal.comment.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.Objects;


/**
 * Comment
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

public class Comment {

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String TIME_ZONE = "Asia/Seoul";

    private Integer commentId = null;

    private String commentContent = null;

    private Integer commentWriterId = null;

    private Integer commentParentId = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone = TIME_ZONE)
    private Date commentCreatedAt = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone = TIME_ZONE)
    private Date commentUpdatedAt = null;

    private String commentStatus = null;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent;
    }

    public Integer getCommentWriterId() {
        return commentWriterId;
    }

    public void setCommentWriterId(Integer commentWriterId) {
        this.commentWriterId = commentWriterId;
    }

    public Integer getCommentParentId() {
        return commentParentId;
    }

    public void setCommentParentId(Integer commentParentId) {
        this.commentParentId = commentParentId;
    }

    public Date getCommentCreatedAt() {
        return commentCreatedAt;
    }

    public void setCommentCreatedAt(Date commentCreatedAt) {
        this.commentCreatedAt = commentCreatedAt;
    }

    public Date getCommentUpdatedAt() {
        return commentUpdatedAt;
    }

    public void setCommentUpdatedAt(Date commentUpdatedAt) {
        this.commentUpdatedAt = commentUpdatedAt;
    }

    public String getCommentStatus() {
        return commentStatus;
    }

    public void setCommentStatus(String commentStatus) {
        this.commentStatus = commentStatus;
    }
}

