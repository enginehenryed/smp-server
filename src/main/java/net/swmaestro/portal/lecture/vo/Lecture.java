package net.swmaestro.portal.lecture.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;
import java.util.Objects;


/**
 * Lecture
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

public class Lecture {
    private Integer articleId = null;

    private Integer articleWriterId = null;

    private Integer articleModifierId = null;

    private Integer articleGenerationId = null;

    private String articleSubject = null;

    private String articleContent = null;

    private Date articleCreatedAt = null;

    private Date articleUpdatedAt = null;

    private String articleType = null;

    private String articleStatus = null;

    private Integer lectureTeacherId = null;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lectureBeginAt = null;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date lectureEndAt = null;

    /**
     * Lecture's unique ID.
     * @return articleId
     **/
    @ApiModelProperty(value = "Lecture's unique ID.")
    public Integer getArticleId() {
        return articleId;
    }

    public void setArticleId(Integer articleId) {
        this.articleId = articleId;
    }

    /**
     * Lecture's writer ID.
     * @return articleWriterId
     **/
    @ApiModelProperty(value = "Lecture's writer ID.")
    public Integer getArticleWriterId() {
        return articleWriterId;
    }

    public void setArticleWriterId(Integer articleWriterId) {
        this.articleWriterId = articleWriterId;
    }

    /**
     * Lecture's modifier ID.
     * @return articleModifierId
     **/
    @ApiModelProperty(value = "Lecture's modifier ID.")
    public Integer getArticleModifierId() {
        return articleModifierId;
    }

    public void setArticleModifierId(Integer articleModifierId) {
        this.articleModifierId = articleModifierId;
    }

    /**
     * Lecture's generation ID.
     * @return articleGenerationId
     **/
    @ApiModelProperty(value = "Lecture's generation ID.")
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
     * Lecture's article content.
     * @return articleContent
     **/
    @ApiModelProperty(value = "Lecture's article content.")
    public String getArticleContent() {
        return articleContent;
    }

    public void setArticleContent(String articleContent) {
        this.articleContent = articleContent;
    }

    /**
     * Lecture's article created at.
     * @return articleCreatedAt
     **/
    @ApiModelProperty(value = "Lecture's article created at.")
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

    public Integer getLectureTeacherId() {
        return lectureTeacherId;
    }

    public void setLectureTeacherId(Integer lectureTeacherId) {
        this.lectureTeacherId = lectureTeacherId;
    }

    public Date getLectureBeginAt() {
        return lectureBeginAt;
    }

    public void setLectureBeginAt(Date lectureBeginAt) {
        this.lectureBeginAt = lectureBeginAt;
    }

    public Date getLectureEndAt() {
        return lectureEndAt;
    }

    public void setLectureEndAt(Date lectureEndAt) {
        this.lectureEndAt = lectureEndAt;
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
        Lecture lecture = (Lecture) o;
        return Objects.equals(this.userId, lecture.userId) &&
                Objects.equals(this.userEmail, lecture.userEmail) &&
                Objects.equals(this.userName, lecture.userName);*/
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

