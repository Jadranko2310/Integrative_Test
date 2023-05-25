package POJO.response.user_controller.login;

import lombok.Getter;
import lombok.Setter;

/**
 * Log in Response deserialization model.
 */
@Getter
@Setter
public class LogInResponseBody {

  private String accessToken;

  private String refreshToken;

  private User user;


}
