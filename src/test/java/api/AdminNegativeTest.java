package api;

import Helpers.CustomAssert;
import Helpers.UserIDFromList;
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
import setup.common.helpers.TokenGenerator;
import setup.common.constants.UserConstants;
import specification.api.request.*;
@Epic("API Tests - Negative Admin CRUD operations")
@Feature("Basic CRUD operations, Role: Admin, Entity: User")
public class AdminNegativeTest extends BaseAPITest {
  TokenGenerator tokenNegative = new TokenGenerator(UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);
  UserIDFromList usersId = new UserIDFromList();
  CustomAssert customAssert = new CustomAssert();
  LogInRequest logIn = new LogInRequest();
  CreateUserRequest newUser = new CreateUserRequest();
  GetUsersListRequest getAllUsers = new GetUsersListRequest();
  UpdateUserRequest updateUserRequest = new UpdateUserRequest();
  DeleteUserRequest deleteUserRequest = new DeleteUserRequest();

  @Test(dataProvider = "LogInUnauthorizedData", dataProviderClass = LogInData.class,
  description = "Admin sending log in request with invalid credentials, " +
          "expecting to get reject response message")
  public void unauthorizedLogIn(LogInRequestBody requestBody,
                                NotAuthorizedResponseBody expectedResponseBody) {
    response = logIn.request(requestBody.getEmail(), requestBody.getPassword());
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
    response = getAllUsers.list("no token");
    NotAuthorizedGetAllUsersResponseBody responseBody =
            response.as(NotAuthorizedGetAllUsersResponseBody.class);

    softAssert.assertEquals(response.statusCode(), 401);
    softAssert.assertEquals(responseBody.getError(),"Unauthorized");
    softAssert.assertAll("These are the issues: ");
  }

  @Test(description = "Admin sending request to update user with invalid " +
          "email attribute, expecting to get reject response")
  public void updateUserWithInvalidEmailFormat() throws Exception {
    int userID = usersId.find(UserConstants.USER_UPDATE_EMAIL, tokenNegative.getToken());
    UpdateUserRequestBody requestBody = new UpdateUserRequestBody();
    requestBody.setEmail("notReqularEmail.com");
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
