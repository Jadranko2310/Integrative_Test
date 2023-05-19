package POJO.request;

import lombok.Getter;
import lombok.Setter;

/**
 * Log in body.
 */
@Getter
@Setter
public class LogInRequestBody {

  private String email;

  private String password;

  public LogInRequestBody(String email, String password) {
    this.email = email;
    this.password = password;
  }
}
