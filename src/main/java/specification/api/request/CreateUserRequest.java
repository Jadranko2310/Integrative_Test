package specification.api.request;

import POJO.request.user_controler.User;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import setup.common.specification.Constants;

public class CreateUserRequest {


  public Response create (User user, String token) {
    RequestSpecification request = RestAssured
            .given()
            .baseUri(Constants.BASE_URI)
            .contentType(ContentType.JSON)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .relaxedHTTPSValidation();
    return request.header("Authorization", token)
            .body(user)
            .post(Constants.CREATE_USER);
  }
}
