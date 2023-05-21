package api;

import Helpers.CustomAssert;
import Helpers.UserIDFromList;
import POJO.request.auth_controler.LogInRequestBody;
import POJO.request.user_controler.UpdateUserRequestBody;
import POJO.request.user_controler.User;
import POJO.response.user_controller.login.NotAuthorizedResponseBody;
import POJO.response.user_controller.single_user.CreateUserResponseBody;
import POJO.response.user_controller.single_user.InvalidRequestUpdateResponseBody;
import POJO.response.user_controller.single_user.NotAuthorizedGetAllUsersResponseBody;
import data.provider.LogInData;
import org.testng.annotations.Test;
import setup.api.BaseAPITest;
import setup.common.helpers.TokenGenerator;
import setup.common.specification.Constants;
import specification.api.request.*;

public class AdminNegativeTest extends BaseAPITest {
  TokenGenerator tokenNegative = new TokenGenerator(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
  UserIDFromList usersId = new UserIDFromList();
  CustomAssert customAssert = new CustomAssert();
  LogInRequest logIn = new LogInRequest();
  CreateUserRequest newUser = new CreateUserRequest();
  GetUsersListRequest getAllUsers = new GetUsersListRequest();
  UpdateUserRequest updateUserRequest = new UpdateUserRequest();
  DeleteUserRequest deleteUserRequest = new DeleteUserRequest();

  @Test(dataProvider = "LogInUnauthorizedData", dataProviderClass = LogInData.class)
  public void unauthorizedLogIn(LogInRequestBody requestBody,
                                NotAuthorizedResponseBody expectedResponseBody) {
    response = logIn.request(requestBody.getEmail(), requestBody.getPassword());
    NotAuthorizedResponseBody actualResponseBody =
            response.as(NotAuthorizedResponseBody.class);
    softAssert.assertEquals(expectedResponseBody.getMessage(),
            actualResponseBody.getMessage(),
            "Response message not as expected");
  }

  @Test
  public void createUserRequestWithInvalidBody() {
    User user = new User();
    user.setEmail("");
    user.setPassword(Constants.REGULAR_USER_PASS);
    user.setName(Constants.REGULAR_USER_NAME);
    user.setPhone(Constants.REGULAR_USER_PHONE);

    response = newUser.create(user, tokenNegative.getToken());
    CreateUserResponseBody createUserResponseBody = response.as(CreateUserResponseBody.class);
    customAssert.assertCommonBadRequestAndResponseTime(response);
    softAssert.assertEquals(createUserResponseBody.getEmail(),
            "Field is mandatory", "error message not as expected");
  }

  @Test
  public void getAllUsersWithInvalidToken() {
    response = getAllUsers.list("no token");
    NotAuthorizedGetAllUsersResponseBody responseBody =
            response.as(NotAuthorizedGetAllUsersResponseBody.class);

    softAssert.assertEquals(response.statusCode(), 401);
    softAssert.assertEquals(responseBody.getError(),"Unauthorized");
    softAssert.assertAll("These are the issues: ");
  }

  @Test
  public void updateUserWithInvalidEmailFormat() throws Exception {
    int userID = usersId.find(Constants.USER_UPDATE_EMAIL, tokenNegative.getToken());
    UpdateUserRequestBody requestBody = new UpdateUserRequestBody();
    requestBody.setEmail("notReqularEmail.com");
    requestBody.setName("User Updated");
    requestBody.setPhone("+38765111000");

    response = updateUserRequest.update(userID, tokenNegative.getToken(), requestBody);

    InvalidRequestUpdateResponseBody responseBody =
            response.as(InvalidRequestUpdateResponseBody.class);

    customAssert.assertCommonBadRequestAndResponseTime(response);
    softAssert.assertEquals(responseBody.getEmail(),
            "must be a well-formed email address",
            "Email message not as expected");
  }

  @Test
  public void deleteNonExistentUser() {
    response = deleteUserRequest.delete(0, tokenNegative.getToken());

    softAssert.assertEquals(response.statusCode(), 404);
    softAssert.assertEquals(response.statusLine(), "HTTP/1.1 404 ");
    softAssert.assertAll("These are the issues: ");
  }
}
