package specification.api.request;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import setup.api.BaseAPITest;
import setup.common.specification.Constants;

public class DeleteRequest {

  public Response delete(int userID, String token) {
    RequestSpecification request = RestAssured
            .given()
            .baseUri(Constants.BASE_URI)
            .contentType(ContentType.JSON)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .relaxedHTTPSValidation();
    return request
            .header("Authorization", token)
            .delete(Constants.DELETE_USER + userID);
  }
}
