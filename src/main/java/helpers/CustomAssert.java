package helpers;

import io.restassured.response.Response;
import setup.api.BaseAPITest;

/**
 * Asserts methods containing multiple assert that will be frequent in tests and
 * complex asserts methods.
 */
public class CustomAssert extends BaseAPITest {
  UserIdFromList userIdFromList = new UserIdFromList();

  /**
   * Frequent set of asserts for response 200.
   */
  public void assertCommonStatusCodeAndResponseTime(Response response) {
    softAssert.assertEquals(response.statusCode(), 200,
            "status code not 200");
    softAssert.assertTrue(response.time() < 4000,
            "response time too long");
    softAssert.assertAll("These are the issues");
  }

  /**
   * Frequent set of asserts for response 200.
   */
  public void assertBadRequestAndResponseTime(Response response) {
    softAssert.assertEquals(response.statusCode(), 400,
            "status code not 400");
    softAssert.assertTrue(response.time() < 3000,
            "response time too long");
    softAssert.assertAll("These are the issues");
  }

  /**
   * Will find id on the users list and then check if list of users id's
   * contains the id.
   */
  public void assertThatUserIsOnList(String email, String token) {
    int id = userIdFromList.findId(email, token);
    softAssert.assertTrue(userIdFromList.usersIdList(token).contains(id));
    softAssert.assertAll("These are the issues: ");
  }
}