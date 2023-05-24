package Helpers;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import setup.api.BaseAPITest;
import specification.api.request.GetUsersListRequest;

@Getter
@Setter
public class CustomAssert extends BaseAPITest {

  GetUsersListRequest getAllUsers = new GetUsersListRequest();
  UserIDFromList userIDFromList = new UserIDFromList();

  public void assertCommonStatusCodeAndResponseTime(Response response) {
    softAssert.assertEquals(response.statusCode(), 200,
            "status code not 200");
    softAssert.assertTrue(response.time() < 4000,
            "response time too long");
    softAssert.assertAll("These are the issues");
  }

  public void assertBadRequestAndResponseTime(Response response) {
    softAssert.assertEquals(response.statusCode(), 400,
            "status code not 400");
    softAssert.assertTrue(response.time() < 3000,
            "response time too long");
    softAssert.assertAll("These are the issues");
  }

  public void assertThatUserIsOnList(String email, String token) throws Exception {
    userIDFromList.find(email, token);
    softAssert.assertNotNull(userIDFromList.getId(),
            "User is not on the list");
    softAssert.assertAll();
  }
}
