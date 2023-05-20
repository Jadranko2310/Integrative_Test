package api;

import POJO.request.user_controler.User;
import POJO.request.user_controler.UserType;
import POJO.response.user_controller.login.LogInResponseBody;
import POJO.response.user_controller.users_list.GetAllUsersResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.api.BaseAPITest;
import setup.common.helpers.TokenGenerator;
import setup.common.specification.Constants;
import specification.api.request.GetUsersList;
import specification.api.request.LogIn;
import specification.api.request.NewUser;

public class AdminFunctionalTest extends BaseAPITest {

  TokenGenerator token = new TokenGenerator(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
  LogIn logIn = new LogIn();

  NewUser newUser = new NewUser();
  GetUsersList getAllUsers = new GetUsersList();


  @Test
  public void adminLogIn() {
    response = logIn.request(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
    LogInResponseBody responseBody = response.getBody().as(LogInResponseBody.class);

    softAssert.assertEquals(response.statusCode(), 200);
    softAssert.assertEquals(responseBody.getUser().getUserGroup().getId(), 1);
  }

  @Test
  public void creatingNewUser() {
    User predefinedUser = new User(UserType.STANDARD);
    response = newUser.create(predefinedUser, token.getToken());

    Assert.assertEquals(response.statusCode(), 201);
  }

  @Test
  public void getUsersValues() {
    response = getAllUsers.list(token.getToken());

    GetAllUsersResponseBody responseBody = response.as(GetAllUsersResponseBody.class);

    Assert.assertEquals(response.statusCode(), 200);
    Assert.assertEquals(responseBody.getContent().get(0).getName(), "Apple Review User");

  }
}
