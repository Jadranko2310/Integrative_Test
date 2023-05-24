package data.handling;

import POJO.response.user_controller.users_list.Content;
import POJO.response.user_controller.users_list.GetAllUsersResponseBody;
import io.restassured.response.Response;
import Helpers.TokenGenerator;
import setup.constants.UserConstants;
import specification.api.request.DeleteUserRequest;
import specification.api.request.GetUsersListRequest;

import java.util.List;

public class UserDataCleanUp {

  private final String token;

  public UserDataCleanUp() {
    this.token = tokenGenerator.getToken();
  }

  TokenGenerator tokenGenerator = new TokenGenerator
          (UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);

  GetUsersListRequest getUsersList = new GetUsersListRequest();

  DeleteUserRequest deleteRequest = new DeleteUserRequest();

  public GetAllUsersResponseBody getUsersList() {
    Response response = getUsersList.list(token);
    return response.as(GetAllUsersResponseBody.class);
  }


  public void cleanUpUserTestData() {
    List<Content> contentList = getUsersList().getContent();
    if (contentList.isEmpty()) {
      return;
    }
    for (Content content: contentList) {
      deleteRequest.delete(content.getId(), token);
    }
  }
}
