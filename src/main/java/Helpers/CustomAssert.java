package Helpers;
import POJO.response.user_controller.users_list.GetAllUsersResponseBody;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import setup.api.BaseAPITest;
import specification.api.request.GetUsersList;

@Getter
@Setter
public class CustomAssert extends BaseAPITest {

  GetUsersList getAllUsers = new GetUsersList();
  UserIDFromList userIDFromList = new UserIDFromList();



  public void assertCommonStatusCodeAndResponseTime(Response response) {
    softAssert.assertEquals(response.statusCode(), 200,
            "status code not 200");
    softAssert.assertTrue(response.time() < 3000,
            "response time too long");
    softAssert.assertAll("These are the issues");
  }

  public void assertThatUserIsOnList(String email, String token) throws Exception {
    userIDFromList.findUserId(email, token);
    softAssert.assertNotNull(userIDFromList.getId(),
            "User is not on the list");
    softAssert.assertAll();
  }
}
