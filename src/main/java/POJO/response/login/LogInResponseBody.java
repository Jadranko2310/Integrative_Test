package POJO.response.login;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LogInResponseBody {

  private String accessToken;

  private String refreshToken;

  private User user;


}
