package POJO.request.auth_controller;

import lombok.Getter;
import lombok.Setter;
import setup.common.constants.UserConstants;

/**
 * Log in body.
 */
@Getter
@Setter
public class LogInRequestBody {

  private String email;

  private String password;

  public LogInRequestBody(){}

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
    }
  }
}
