package helpers;

import POJO.response.user_controller.login.LogInResponseBody;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import setup.api.BaseAPITest;
import specification.api.request.LogInRequest;

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
    LogInRequest logIn = new LogInRequest();
    Response response = logIn.logIn(email, pass);
    LogInResponseBody body = response.body().as(LogInResponseBody.class);

    return "Bearer " + body.getAccessToken();
  }
}