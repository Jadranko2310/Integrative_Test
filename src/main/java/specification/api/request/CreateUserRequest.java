package specification.api.request;

import POJO.request.user_controller.User;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import setup.constants.BackendConstants;

/**
 * Create new user request definition.
 */
public class CreateUserRequest {

  public Response create(User user, String token) {
    RequestSpecification request = RestAssured
            .given()
            .baseUri(BackendConstants.BASE_URI)
            .contentType(ContentType.JSON)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .relaxedHTTPSValidation();
    return request.header("Authorization", token)
            .body(user)
            .post(BackendConstants.CREATE_USER);
  }
}
