package specification.api.request;

import POJO.request.auth_controller.LogInRequestBody;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import setup.constants.BackendConstants;

/**
 * Log in request definition.
 */
public class LogInRequest {

  public Response logIn(String email, String password) {
    RequestSpecification request = RestAssured
            .given()
            .baseUri(BackendConstants.BASE_URI)
            .contentType(ContentType.JSON)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .relaxedHTTPSValidation();

    LogInRequestBody requestBody = new LogInRequestBody(email, password);
    request.body(requestBody);
    return request.post(BackendConstants.LOG_IN);
  }
}
