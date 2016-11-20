package net.swmaestro.portal.user.vo;

/**
 * Created by junha on 2016. 11. 14..
 */
public class SimpleUser {
    private Integer userId = null;

    private String userName = null;

    private String userProfileImage = null;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserProfileImage() {
        return userProfileImage;
    }

    public void setUserProfileImage(String userProfileImage) {
        this.userProfileImage = userProfileImage;
    }
}
