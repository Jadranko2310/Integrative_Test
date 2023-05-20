package setup.common.helpers;

import POJO.response.user_controller.login.LogInResponseBody;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
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

    return "Bearer " + body.getAccessToken();
  }
}
