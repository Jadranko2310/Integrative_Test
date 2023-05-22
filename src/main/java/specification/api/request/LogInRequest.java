package specification.api.request;

import POJO.request.auth_controller.LogInRequestBody;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import setup.common.constants.APIConstants;

public class LogInRequest {

  public Response request(String email, String password) {
    RequestSpecification request = RestAssured
            .given()
            .baseUri(APIConstants.BASE_URI)
            .contentType(ContentType.JSON)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .relaxedHTTPSValidation();

    LogInRequestBody requestBody = new LogInRequestBody(email, password);
    request.body(requestBody);
    return request.post(APIConstants.LOG_IN);
  }
}
