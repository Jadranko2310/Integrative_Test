package common.api_setup.base;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import lombok.Getter;
import lombok.Setter;
import org.testng.asserts.SoftAssert;

@Getter
@Setter
public abstract class BaseTest {

  protected RequestSpecification request;
  protected ResponseSpecification responseSpecification;
  protected Response response;
  protected SoftAssert softAssert;

  /**
   * Defining request and response specification.
   */
  public BaseTest() {
    this.request = RestAssured
            .given()
            .baseUri(Endpoints.BASE_URI)
            .contentType(ContentType.JSON)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .relaxedHTTPSValidation();

    this.responseSpecification =
            new ResponseSpecBuilder()
                    .expectContentType(ContentType.JSON)
                    .expectHeader("Content-Type", "application/json")
                    .build();

    this.softAssert = new SoftAssert();
  }
}
