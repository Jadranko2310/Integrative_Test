package setup.common.helpers;

import POJO.response.login.LogInResponseBody;
import lombok.Getter;
import lombok.Setter;
import setup.api.BaseAPITest;
import specification.api.request.LogIn;

/**
 * Will generate token for API requests.
 */
@Getter
@Setter
public class TokenGenerator extends BaseAPITest {

  private String token;

  public TokenGenerator() {
  }

  public TokenGenerator(String email, String pass) {
    this.token = accessToken(email, pass);
  }

  private String accessToken(String email, String pass) {
    LogIn logIn = new LogIn();
    response = logIn.request(email, pass);
    LogInResponseBody body = response.body().as(LogInResponseBody.class);

    String preparedToken = "Bearer " + body.getAccessToken().toString();
    return preparedToken;
  }
}
