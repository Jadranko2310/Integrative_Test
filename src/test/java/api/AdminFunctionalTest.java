package api;

import helpers.CustomAssert;
import helpers.UserIdFromList;
import POJO.request.user_controller.UpdateUserRequestBody;
import POJO.request.user_controller.User;
import POJO.request.user_controller.UserType;
import POJO.response.user_controller.login.LogInResponseBody;
import POJO.response.user_controller.single_user.CreateUserResponseBody;
import POJO.response.user_controller.single_user.UpdateUserResponseBody;
import POJO.response.user_controller.users_list.GetAllUsersResponseBody;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import setup.api.BaseAPITest;
import helpers.TokenGenerator;
import setup.constants.UserConstants;
import specification.api.request.*;

@Epic("API tests - Admin CRUD operations")
@Feature("Base CRUD OPERATION, Role: Admin, Entity: User")
public class AdminFunctionalTest extends BaseAPITest {


  TokenGenerator token = new TokenGenerator(UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);
  LogInRequest logIn = new LogInRequest();
  CreateUserRequest newUser = new CreateUserRequest();
  GetUsersListRequest getAllUsers = new GetUsersListRequest();
  UpdateUserRequest updateUserRequest = new UpdateUserRequest();
  DeleteUserRequest deleteRequest = new DeleteUserRequest();

  CustomAssert customAssert = new CustomAssert();
  UserIdFromList userIDFromListsersId = new UserIdFromList();

  @Test(description = "Admin sending log in request with valid email and pass," +
          "expecting to be logged in")
  public void adminLogIn() {
    response = logIn.request(UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);
    LogInResponseBody responseBody = response.getBody().as(LogInResponseBody.class);

    customAssert.assertCommonStatusCodeAndResponseTime(response);
    softAssert.assertEquals(responseBody.getUser().getUserGroup().getKey(), "ADMIN");
    softAssert.assertAll("There are the issues: ");
  }

  @Test(description = "Admin sending request for creating new user with valid" +
          "credential, expecting the new user to be created")
  public void createNewUser() throws Exception {
    User predefinedUser = new User(UserType.STANDARD);
    response = newUser.create(predefinedUser, token.getToken());
    CreateUserResponseBody createUserResponseBody = response.as(CreateUserResponseBody.class);
    // Assert
    softAssert.assertEquals(response.statusCode(), 201);
    softAssert.assertTrue(response.time() < 4000);
    softAssert.assertEquals(createUserResponseBody.getEmail(), predefinedUser.getEmail());
    // Check if user is on the users list
    customAssert.assertThatUserIsOnList(predefinedUser.getEmail(), token.getToken());
  }

  @Test(description = "Admin sending request for list of all users," +
          "expecting to get list of all users in response")
  public void getUsersList() {
    response = getAllUsers.list(token.getToken());

    GetAllUsersResponseBody responseBody = response.as(GetAllUsersResponseBody.class);

    customAssert.assertCommonStatusCodeAndResponseTime(response);
    softAssert.assertNotNull(responseBody.getContent());
  }

  @Test(description = "Admin sending request for updating existing user " +
          "with valid user Id and valid new data expecting the user to be changed")
  public void updateUser() throws Exception {
    int userID = userIDFromListsersId.findId(UserConstants.USER_UPDATE_EMAIL, token.getToken());
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

  @Test(description = "Admin sending request to delete user with valid user Id, " +
          "expecting that user will be deleted")
  public void deleteUser() throws Exception {
    int userID = userIDFromListsersId.findId(UserConstants.USER_DELETE_EMAIL, token.getToken());

    response = deleteRequest.delete(userID, token.getToken());

    customAssert.assertCommonStatusCodeAndResponseTime(response);
  }
}
