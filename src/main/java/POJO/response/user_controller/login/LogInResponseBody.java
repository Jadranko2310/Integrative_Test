package POJO.response.user_controller.login;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogInResponseBody {

  private String accessToken;

  private String refreshToken;

  private User user;


}
