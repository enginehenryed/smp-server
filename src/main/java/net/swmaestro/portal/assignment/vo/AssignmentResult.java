package net.swmaestro.portal.assignment.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import net.swmaestro.portal.user.vo.SimpleUser;

import java.util.Date;

/**
 * Created by junha on 2016. 11. 14..
 */
public class AssignmentResult {

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String TIME_ZONE = "Asia/Seoul";

    private Integer articleId = null;

    private Integer articleGenerationId = null;

    private String articleSubject = null;

    private String articleContent = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone = TIME_ZONE)
    private Date articleCreatedAt = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone = TIME_ZONE)
    private Date articleUpdatedAt = null;

    private String articleType = null;

    private String articleStatus = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone = TIME_ZONE)
    private Date assignmentEndAt = null;

    private SimpleUser articleWriter = null;

    private SimpleUser articleModifier = null;

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

    public SimpleUser getArticleWriter() {
        return articleWriter;
    }

    public void setArticleWriter(SimpleUser articleWriter) {
        this.articleWriter = articleWriter;
    }

    public SimpleUser getArticleModifier() {
        return articleModifier;
    }

    public void setArticleModifier(SimpleUser articleModifier) {
        this.articleModifier = articleModifier;
    }
}
