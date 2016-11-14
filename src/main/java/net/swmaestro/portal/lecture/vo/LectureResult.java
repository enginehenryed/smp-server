package net.swmaestro.portal.lecture.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import net.swmaestro.portal.user.vo.SimpleUser;

import java.util.Date;

/**
 * Created by junha on 2016. 11. 14..
 */
public class LectureResult {

    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String TIME_ZONE = "Asia/Seoul";

    private Integer articleId = null;

    private SimpleUser articleWriter = null;

    private SimpleUser articleModifier = null;

    private Integer articleGenerationId = null;

    private String articleSubject = null;

    private String articleContent = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone = TIME_ZONE)
    private Date articleCreatedAt = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone = TIME_ZONE)
    private Date articleUpdatedAt = null;

    private String articleType = null;

    private String articleStatus = null;

    private SimpleUser lectureTeacher = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone = TIME_ZONE)
    private Date lectureBeginAt = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone = TIME_ZONE)
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

    public SimpleUser getLectureTeacher() {
        return lectureTeacher;
    }

    public void setLectureTeacher(SimpleUser lectureTeacher) {
        this.lectureTeacher = lectureTeacher;
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
