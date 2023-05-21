package specification.api.request;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import setup.common.constants.APIConstants;

public class GetUsersListRequest {

  public Response list(String token) {
    RequestSpecification request = RestAssured
            .given()
            .baseUri(APIConstants.BASE_URI)
            .contentType(ContentType.JSON)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .header("Authorization", token)
            .relaxedHTTPSValidation();
    return request
            .param("page", 0)
            .param("pageSize", 10)
            .param("filterColumn", "all")
            .param("orderColumn", "name")
            .param("orderValue", "ascend")
            .get(APIConstants.ALL_USERS);
  }
}
