package net.swmaestro.portal.user.vo;

import java.util.Objects;

import io.swagger.annotations.ApiModelProperty;




/**
 * User
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2016-10-05T11:30:19.659Z")

public class User   {
  private Integer userId = null;

  private String userEmail = null;

  private String userName = null;

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

