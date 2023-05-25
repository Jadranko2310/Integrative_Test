package data.handling;

import helpers.TokenGenerator;
import POJO.response.user_controller.users_list.Content;
import POJO.response.user_controller.users_list.GetAllUsersResponseBody;
import io.restassured.response.Response;
import java.util.List;
import setup.constants.UserConstants;
import specification.api.request.DeleteUserRequest;
import specification.api.request.GetUsersListRequest;

/**
 * Deleting all test users.
 */
public class UserDataCleanUp {

  private final String token;

  public UserDataCleanUp() {
    this.token = tokenGenerator.getToken();
  }

  TokenGenerator tokenGenerator = new TokenGenerator(
          UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);

  GetUsersListRequest getUsers = new GetUsersListRequest();

  DeleteUserRequest deleteUserRequest = new DeleteUserRequest();

  public GetAllUsersResponseBody getUsersList() {
    Response response = getUsers.getList(token);
    return response.as(GetAllUsersResponseBody.class);
  }

  /**
   * Will go through list of objects 'Content', take request id
   * and use it for deleting users.
   */
  public void cleanUpUserTestData() {
    List<Content> contentList = getUsersList().getContent();
    if (contentList.isEmpty()) {
      return;
    }
    for (Content content : contentList) {
      deleteUserRequest.delete(content.getId(), token);
    }
  }
}