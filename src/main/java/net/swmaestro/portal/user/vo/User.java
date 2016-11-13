package net.swmaestro.portal.user.vo;

import java.util.List;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;




/**
 * User
 */

public class User   {
    private static final String DATE_PATTERN = "yyyy-MM-dd HH:mm:ss";
    private static final String TIME_ZONE = "Asia/Seoul";

    private Integer userId = null;

    private String userEmail = null;

    private String userName = null;

    private String userPassword = null;

    private String userPhone = null;

    private String userGender = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone = TIME_ZONE)
    private String userCreatedAt = null;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern=DATE_PATTERN, timezone = TIME_ZONE)
    private String userUpdatedAt = null;

    private List<Group> userGroups = null;

    private String userStatus = null;

    public User userId(Integer userId) {
        this.userId = userId;
        return this;
    }

    /**
     * User's unique ID.
     * @return userId
     **/
    @ApiModelProperty(value = "User's unique ID.")
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public User userEmail(String userEmail) {
        this.userEmail = userEmail;
        return this;
    }

    /**
     * User's email address.
     * @return userEmail
     **/
    @ApiModelProperty(required = true, value = "User's email address.")
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public User userName(String userName) {
        this.userName = userName;
        return this;
    }

    /**
     * User's name.
     * @return userName
     **/
    @ApiModelProperty(required = true, value = "User's name.")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * User's password.
     * @return userPassword
     **/
    @ApiModelProperty(required = true, value = "User's password.")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserGender() {
        return userGender;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public String getUserCreatedAt() {
        return userCreatedAt;
    }

    public void setUserCreatedAt(String userCreatedAt) {
        this.userCreatedAt = userCreatedAt;
    }

    public String getUserUpdatedAt() {
        return userUpdatedAt;
    }

    public void setUserUpdatedAt(String userUpdatedAt) {
        this.userUpdatedAt = userUpdatedAt;
    }

    public List<Group> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<Group> userGroups) {
        this.userGroups = userGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(this.userId, user.userId) &&
                Objects.equals(this.userEmail, user.userEmail) &&
                Objects.equals(this.userName, user.userName);
    }

    public String getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userEmail, userName);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class User {\n");

        sb.append("    userId: ").append(toIndentedString(userId)).append("\n");
        sb.append("    userEmail: ").append(toIndentedString(userEmail)).append("\n");
        sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
        sb.append("}");
        return sb.toString();
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

