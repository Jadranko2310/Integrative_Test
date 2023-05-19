package setup.common.helpers;

import POJO.response.login.LogInResponseBody;
import io.restassured.response.ResponseBody;
import lombok.Getter;
import lombok.Setter;
import setup.api.BaseAPITest;
import setup.common.specification.Constants;
import specification.api.request.LogIn;

/**
 * Will generate token for API requests.
 */
@Getter
@Setter
public class Token extends BaseAPITest {

  private String token;

  public Token(String email, String pass) {
    this.token = accessToken(email, pass);
  }

  private String accessToken(String email, String pass) {
    LogIn logIn = new LogIn();
    response = logIn.request(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
    LogInResponseBody body = response.body().as(LogInResponseBody.class);
    return body.getAccessToken();
  }
}
