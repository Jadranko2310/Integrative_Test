package POJO.request.auth_controller;

import lombok.Getter;
import lombok.Setter;
import setup.constants.UserConstants;

/**
 * Log in body.
 */
@Getter
@Setter
public class LogInRequestBody {

  private String email;

  private String password;

  public LogInRequestBody() {}

  public LogInRequestBody(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public LogInRequestBody(UserType userType) {
    switch (userType) {
      case REGULAR -> {
        this.email = UserConstants.RECORDS_USER_EMAIL;
        this.password = UserConstants.RECORDS_USER_PASS;
      }
      case ADMIN -> {
        this.email = UserConstants.ADMIN_EMAIL;
        this.password = UserConstants.ADMIN_PASS;
      }
      default -> throw new RuntimeException("User type for login request invalid, "
              + "please check Log In request Body and request");
    }
  }
}
