package data.cleanup;

import POJO.response.user_controller.users_list.Content;
import POJO.response.user_controller.users_list.GetAllUsersResponseBody;
import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import setup.common.helpers.TokenGenerator;
import setup.common.specification.Constants;

import java.util.List;


public class AdminActivityCleanup {


   RequestSpecification request = RestAssured
          .given()
          .baseUri(Constants.BASE_URI)
          .contentType(ContentType.JSON)
          .filter(new RequestLoggingFilter())
          .filter(new ResponseLoggingFilter())
          .relaxedHTTPSValidation();

  ResponseSpecification responseSpecification = new ResponseSpecBuilder()
          .expectContentType(ContentType.JSON)
          .expectHeader("Content-Type", "application/json")
          .build();

  private  Response response;
  TokenGenerator tokenGenerator = new TokenGenerator
          (Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);

  public GetAllUsersResponseBody getUsersList() {
    RequestSpecification request2 = RestAssured
            .given()
            .baseUri(Constants.BASE_URI)
            .contentType(ContentType.JSON)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .relaxedHTTPSValidation();
    Response response1 = request2.header("Authorization", tokenGenerator.getToken())
            .param("page", 0)
            .param("pageSize", 10)
            .param("filterColumn", "all")
            .param("orderColumn", "name")
            .param("orderValue", "ascend")
            .get(Constants.ALL_USERS);

    return response1.as(GetAllUsersResponseBody.class);
  }

  public Response deleteUser(int userID) {
    RequestSpecification request2 = RestAssured
            .given()
            .baseUri(Constants.BASE_URI)
            .contentType(ContentType.JSON)
            .filter(new RequestLoggingFilter())
            .filter(new ResponseLoggingFilter())
            .relaxedHTTPSValidation();
    return request2
            .header("Authorization", tokenGenerator.getToken())
            .delete(Constants.DELETE_USER + userID);
  }


  public void cleanUpTestData() {
    List<Content> contentList = getUsersList().getContent();
    if (contentList.isEmpty()) {
      return;
    }
    for (Content content: contentList) {
      int userId = content.getId();
      deleteUser(userId);
    }
  }

}
