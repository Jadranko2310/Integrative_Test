package specification.api.request;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import setup.constants.BackendConstants;

/**
 * Get all records request definition.
 */
public class GetAllRecordsRequest {

  public Response getList(String token) {
    RequestSpecification request = RestAssured
            .given()
            .baseUri(BackendConstants.BASE_URI)
            .contentType(ContentType.JSON)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .header("Authorization", token)
            .relaxedHTTPSValidation();
    return request
            .param("page", 0)
            .param("pageSize", 10)
            .param("orderColumn", "name")
            .param("orderValue", "ascend")
            .get(BackendConstants.GET_ALL_RECORDS_ADMIN);
  }
}