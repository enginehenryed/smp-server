package net.swmaestro.portal.assignment.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import net.swmaestro.portal.attachment.vo.Attachment;

import java.util.Date;
import java.util.List;
import java.util.Objects;


/**
 * Assignment
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

public class Assignment {

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String TIME_ZONE = "Asia/Seoul";

    private Integer articleId = null;

    private Integer articleWriterId = null;

    private Integer articleModifierId = null;

    private Integer articleGenerationId = null;

    private String articleSubject = null;

    private String articleContent = null;

    private List<String> articleAttachmentIds = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone = TIME_ZONE)
    private Date articleCreatedAt = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone = TIME_ZONE)
    private Date articleUpdatedAt = null;

    private String articleType = null;

    private String articleStatus = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone = TIME_ZONE)
    private Date assignmentEndAt = null;


    /**
     * Assignment's unique ID.
     * @return articleId
     **/
    @ApiModelProperty(value = "Assignment's unique ID.")
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * Assignment's writer ID.
     * @return articleWriterId
     **/
    @ApiModelProperty(value = "Assignment's writer ID.")
    public Integer getArticleWriterId() {
        return articleWriterId;
    }

    public void setArticleWriterId(Integer articleWriterId) {
        this.articleWriterId = articleWriterId;
    }

    /**
     * Assignment's modifier ID.
     * @return articleModifierId
     **/
    @ApiModelProperty(value = "Assignment's modifier ID.")
    public Integer getArticleModifierId() {
        return articleModifierId;
    }

    public void setArticleModifierId(Integer articleModifierId) {
        this.articleModifierId = articleModifierId;
    }

    /**
     * Assignment's generation ID.
     * @return articleGenerationId
     **/
    @ApiModelProperty(value = "Assignment's generation ID.")
    public Integer getArticleGenerationId() {
        return articleGenerationId;
    }

    public void setArticleGenerationId(Integer articleGenerationId) {
        this.articleGenerationId = articleGenerationId;
    }


    public String getArticleSubject() {
        return articleSubject;
    }

    public void setArticleSubject(String articleSubject) {
        this.articleSubject = articleSubject;
    }

    /**
     * Assignment's article content.
     * @return articleContent
     **/
    @ApiModelProperty(value = "Assignment's article content.")
    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    public List<String> getArticleAttachmentIds() {
        return articleAttachmentIds;
    }

    public void setArticleAttachmentIds(List<String> articleAttachmentIds) {
        this.articleAttachmentIds = articleAttachmentIds;
    }

    /**
     * Assignment's article created at.
     * @return articleCreatedAt
     **/
    @ApiModelProperty(value = "Assignment's article created at.")
    public Date getArticleCreatedAt() {
        return articleCreatedAt;
    }

    public void setArticleCreatedAt(Date articleCreatedAt) {
        this.articleCreatedAt = articleCreatedAt;
    }

    public Date getArticleUpdatedAt() {
        return articleUpdatedAt;
    }

    public void setArticleUpdatedAt(Date articleUpdatedAt) {
        this.articleUpdatedAt = articleUpdatedAt;
    }

    public String getArticleType() {
        return articleType;
    }

    public void setArticleType(String articleType) {
        this.articleType = articleType;
    }

    public String getArticleStatus() {
        return articleStatus;
    }

    public void setArticleStatus(String articleStatus) {
        this.articleStatus = articleStatus;
    }

    public Date getAssignmentEndAt() {
        return assignmentEndAt;
    }

    public void setAssignmentEndAt(Date assignmentEndAt) {
        this.assignmentEndAt = assignmentEndAt;
    }


    @Override
    public boolean equals(Object o) {
        /*TODO
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Assignment assignment = (Assignment) o;
        return Objects.equals(this.userId, assignment.userId) &&
                Objects.equals(this.userEmail, assignment.userEmail) &&
                Objects.equals(this.userName, assignment.userName);*/
        return false;
    }

    @Override
    public int hashCode() {
        //TODO
        return Objects.hash();
    }

    @Override
    public String toString() {
        //TODO
        return "toString";
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

