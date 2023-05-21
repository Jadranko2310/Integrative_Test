package POJO.response.user_controller.login;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NotAuthorizedResponseBody {
  public String message;

  public NotAuthorizedResponseBody(){}

  public NotAuthorizedResponseBody(String message) {
    this.message = message;
  }
}
