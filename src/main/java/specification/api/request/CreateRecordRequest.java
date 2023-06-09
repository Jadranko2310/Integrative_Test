package specification.api.request;

import POJO.request.records_controller.Record;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import setup.constants.BackendConstants;

/**
 * Create new Record request definition.
 */
public class CreateRecordRequest {

  public Response create(Record record, String token) {
    RequestSpecification request = RestAssured
            .given()
            .baseUri(BackendConstants.BASE_URI)
            .contentType(ContentType.JSON)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .relaxedHTTPSValidation();
    return request.header("Authorization", token)
            .body(record)
            .post(BackendConstants.CREATE_RECORD);
  }
}
