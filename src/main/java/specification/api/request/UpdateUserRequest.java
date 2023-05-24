package specification.api.request;

import POJO.request.user_controller.UpdateUserRequestBody;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import setup.constants.APIConstants;

public class UpdateUserRequest {
  public Response update(int userID, String token, UpdateUserRequestBody requestBody) {
    RequestSpecification request = RestAssured
            .given()
            .baseUri(APIConstants.BASE_URI)
            .contentType(ContentType.JSON)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .relaxedHTTPSValidation()
            .body(requestBody);
    return request
            .header("Authorization", token)
            .put(APIConstants.UPDATE_USER + userID);
  }
}
