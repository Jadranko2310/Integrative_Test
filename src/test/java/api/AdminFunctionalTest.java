package api;

import POJO.request.user_controler.User;
import POJO.request.user_controler.UserType;
import POJO.response.user_controller.login.LogInResponseBody;
import POJO.response.user_controller.single_user.CreateUserResponseBody;
import POJO.response.user_controller.users_list.GetAllUsersResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.api.BaseAPITest;
import setup.common.helpers.TokenGenerator;
import setup.common.specification.Constants;
import specification.api.request.DeleteRequest;
import specification.api.request.GetUsersList;
import specification.api.request.LogInRequest;
import specification.api.request.CreateUserRequest;

public class AdminFunctionalTest extends BaseAPITest {

  TokenGenerator token = new TokenGenerator(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
  LogInRequest logIn = new LogInRequest();
  CreateUserRequest newUser = new CreateUserRequest();
  GetUsersList getAllUsers = new GetUsersList();
  DeleteRequest deleteRequest = new DeleteRequest();


  @Test
  public void adminLogIn() {
    response = logIn.request(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
    LogInResponseBody responseBody = response.getBody().as(LogInResponseBody.class);

    softAssert.assertEquals(response.statusCode(), 200);
    softAssert.assertTrue(response.time() < 3000);
    softAssert.assertEquals(responseBody.getUser().getUserGroup().getKey(), "ADMIN");
    softAssert.assertAll("There are the issues: ");
  }

  @Test
  public void creatingNewUser() {
    User predefinedUser = new User(UserType.STANDARD);
    response = newUser.create(predefinedUser, token.getToken());
    CreateUserResponseBody responseBody = response.as(CreateUserResponseBody.class);

    softAssert.assertEquals(response.statusCode(), 201);
    softAssert.assertTrue(response.time() < 3000);
    softAssert.assertEquals(responseBody.getEmail(), "testuser@gmail.com");
  }

  @Test
  public void getUsersValues() {
    response = getAllUsers.list(token.getToken());

    GetAllUsersResponseBody responseBody = response.as(GetAllUsersResponseBody.class);

    Assert.assertEquals(response.statusCode(), 200);
  }

  @Test
  public void deleteUser() {
    response = getAllUsers.list(token.getToken());
    GetAllUsersResponseBody responseBody = response.as(GetAllUsersResponseBody.class);

    int firstId = responseBody.getContent().get(0).getId();
    response = deleteRequest.delete(firstId, token.getToken());

    Assert.assertEquals(response.statusCode(), 200);
  }
}
