package specification.api.request;

import POJO.request.LogInRequestBody;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import setup.api.BaseTest;
import setup.common.specification.Constants;

public class LogIn extends BaseTest {

  public Response request(String email, String password) {
    request = RestAssured
            .given()
            .baseUri(Constants.BASE_URI)
            .contentType(ContentType.JSON)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .relaxedHTTPSValidation();


    LogInRequestBody requestBody = new LogInRequestBody(email, password);
    request.body(requestBody);
    response = request.post(Constants.LOG_IN);
    return response;
  }
}
