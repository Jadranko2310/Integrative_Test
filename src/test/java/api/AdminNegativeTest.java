package api;

import helpers.CustomAssert;
import helpers.UserIdFromList;
import POJO.request.auth_controller.LogInRequestBody;
import POJO.request.user_controller.UpdateUserRequestBody;
import POJO.request.user_controller.User;
import POJO.response.user_controller.login.NotAuthorizedResponseBody;
import POJO.response.user_controller.single_user.CreateUserResponseBody;
import POJO.response.user_controller.single_user.InvalidRequestUpdateResponseBody;
import POJO.response.user_controller.single_user.NotAuthorizedGetAllUsersResponseBody;
import data.provider.LogInData;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import setup.api.BaseAPITest;
import helpers.TokenGenerator;
import setup.constants.UserConstants;

@Epic("Negative API Tests for basic admin CRUD operations")
@Feature("Basic CRUD operations, Role: Admin, Entity: User")
public class AdminNegativeTest extends BaseAPITest {
  TokenGenerator tokenNegative = new TokenGenerator(UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);
  UserIdFromList usersId = new UserIdFromList();
  CustomAssert customAssert = new CustomAssert();

  @Test(dataProvider = "LogInUnauthorizedData", dataProviderClass = LogInData.class,
  description = "Admin sending log in request with invalid credentials, " +
          "expecting to get reject response message")
  public void unauthorizedLogIn(LogInRequestBody requestBody,
                                NotAuthorizedResponseBody expectedResponseBody) {
    response = logIn.logIn(requestBody.getEmail(), requestBody.getPassword());
    NotAuthorizedResponseBody actualResponseBody =
            response.as(NotAuthorizedResponseBody.class);
    softAssert.assertEquals(expectedResponseBody.getMessage(),
            actualResponseBody.getMessage(),
            "Response message not as expected");
  }

  @Test(description = "Admin sending request to create new user with invalid email" +
          "in the request, expecting to get reject response")
  public void createUserRequestWithInvalidBody() {
    User user = new User();
    user.setEmail("");
    user.setPassword(UserConstants.REGULAR_USER_PASS);
    user.setName(UserConstants.REGULAR_USER_NAME);
    user.setPhone(UserConstants.REGULAR_USER_PHONE);

    response = newUser.create(user, tokenNegative.getToken());
    CreateUserResponseBody createUserResponseBody = response.as(CreateUserResponseBody.class);
    customAssert.assertBadRequestAndResponseTime(response);
    softAssert.assertEquals(createUserResponseBody.getEmail(),
            "Field is mandatory", "error message not as expected");
  }

  @Test(description = "Admin sending request to get list of users with invalid" +
          "token, expecting to get reject response")
  public void getAllUsersWithInvalidToken() {
    response = getAllUsers.getList("no token");
    NotAuthorizedGetAllUsersResponseBody responseBody =
            response.as(NotAuthorizedGetAllUsersResponseBody.class);

    softAssert.assertEquals(response.statusCode(), 401);
    softAssert.assertEquals(responseBody.getError(),"Unauthorized");
    softAssert.assertAll("These are the issues: ");
  }

  @Test(description = "Admin sending request to update user with invalid " +
          "email attribute, expecting to get reject response")
  public void updateUserWithInvalidEmailFormat() {
    int userID = usersId.findId(UserConstants.USER_UPDATE_EMAIL, tokenNegative.getToken());
    UpdateUserRequestBody requestBody = new UpdateUserRequestBody();
    requestBody.setEmail("notRegularEmail.com");
    requestBody.setName("User Updated");
    requestBody.setPhone("+38765111000");

    response = updateUserRequest.update(userID, tokenNegative.getToken(), requestBody);

    InvalidRequestUpdateResponseBody responseBody =
            response.as(InvalidRequestUpdateResponseBody.class);

    customAssert.assertBadRequestAndResponseTime(response);
    softAssert.assertEquals(responseBody.getEmail(),
            "must be a well-formed email address",
            "Email message not as expected");
  }

  @Test(description = "Admin sending request to delete user with non - existing" +
          "user Id, expecting reject response")
  public void deleteNonExistentUser() {
    response = deleteUserRequest.delete(0, tokenNegative.getToken());

    softAssert.assertEquals(response.statusCode(), 404);
    softAssert.assertEquals(response.statusLine(), "HTTP/1.1 404 ");
    softAssert.assertAll("These are the issues: ");
  }
}