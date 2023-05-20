package setup.api;

import data.handling.DataHandler;
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
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;
import setup.common.specification.Constants;

@Getter
@Setter
public abstract class BaseAPITest {

  protected RequestSpecification request;
  protected ResponseSpecification responseSpecification;
  protected Response response;
  protected SoftAssert softAssert;

  /**
   * Defining request and response specification.
   */
  public BaseAPITest() {
    this.request = RestAssured
            .given()
            .baseUri(Constants.BASE_URI)
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

  /**
   * TestNG specification. Defining before and after suite.
   */

  DataHandler dataHandler = new DataHandler();

  @BeforeSuite
  public void prepareData() {
    dataHandler.prepareData();
  }

  @AfterSuite
  public void cleanUp() {
    dataHandler.cleanData();
  }
}
