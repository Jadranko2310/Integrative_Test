package api;

import Helpers.CustomAssert;
import Helpers.UserIDFromList;
import POJO.request.user_controler.UpdateUserRequestBody;
import POJO.request.user_controler.User;
import POJO.request.user_controler.UserType;
import POJO.response.user_controller.login.LogInResponseBody;
import POJO.response.user_controller.single_user.CreateUserResponseBody;
import POJO.response.user_controller.single_user.UpdateUserResponseBody;
import POJO.response.user_controller.users_list.GetAllUsersResponseBody;
import lombok.Getter;
import lombok.Setter;
import org.testng.annotations.Test;
import setup.api.BaseAPITest;
import setup.common.helpers.TokenGenerator;
import setup.common.specification.Constants;
import specification.api.request.*;

@Getter
@Setter
public class AdminFunctionalTest extends BaseAPITest {


  TokenGenerator token = new TokenGenerator(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
  LogInRequest logIn = new LogInRequest();
  CreateUserRequest newUser = new CreateUserRequest();
  GetUsersListRequest getAllUsers = new GetUsersListRequest();
  UpdateUserRequest updateUserRequest = new UpdateUserRequest();
  DeleteUserRequest deleteRequest = new DeleteUserRequest();

  CustomAssert customAssert = new CustomAssert();
  UserIDFromList UsersId = new UserIDFromList();


  @Test
  public void adminLogIn() {
    response = logIn.request(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
    LogInResponseBody responseBody = response.getBody().as(LogInResponseBody.class);

    customAssert.assertCommonStatusCodeAndResponseTime(response);
    softAssert.assertEquals(responseBody.getUser().getUserGroup().getKey(), "ADMIN");
    softAssert.assertAll("There are the issues: ");
  }

  @Test
  public void createNewUser() throws Exception {
    User predefinedUser = new User(UserType.STANDARD);
    response = newUser.create(predefinedUser, token.getToken());
    CreateUserResponseBody createUserResponseBody = response.as(CreateUserResponseBody.class);
    // Assert
    softAssert.assertEquals(response.statusCode(), 201);
    softAssert.assertTrue(response.time() < 3000);
    softAssert.assertEquals(createUserResponseBody.getEmail(), predefinedUser.getEmail());
    // Check if user is on the users list
    customAssert.assertThatUserIsOnList(predefinedUser.getEmail(), token.getToken());
  }

  @Test
  public void getUsersList() {
    response = getAllUsers.list(token.getToken());

    GetAllUsersResponseBody responseBody = response.as(GetAllUsersResponseBody.class);

    customAssert.assertCommonStatusCodeAndResponseTime(response);
    softAssert.assertNotNull(responseBody.getContent());
  }

  @Test
  public void updateUser() throws Exception {
    int userID = UsersId.find(Constants.USER_UPDATE_EMAIL, token.getToken());
    UpdateUserRequestBody requestBody = new UpdateUserRequestBody();
    requestBody.setEmail("updateduser@gmail.com");
    requestBody.setName("User Updated");
    requestBody.setPhone("+38765111000");

    response = updateUserRequest.update(userID, token.getToken(), requestBody);
    UpdateUserResponseBody responseBody = new UpdateUserResponseBody();

    customAssert.assertCommonStatusCodeAndResponseTime(response);
    softAssert.assertEquals(responseBody.getEmail(), requestBody.email);
    softAssert.assertEquals(responseBody.getName(), requestBody.name);
  }

  @Test
  public void deleteUser() throws Exception {
    int userID = UsersId.find(Constants.USER_DELETE_EMAIL, token.getToken());

    response = deleteRequest.delete(userID, token.getToken());

    customAssert.assertCommonStatusCodeAndResponseTime(response);
  }
}
