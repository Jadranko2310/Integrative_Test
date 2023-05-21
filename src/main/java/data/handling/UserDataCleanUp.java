package data.handling;

import POJO.response.user_controller.users_list.Content;
import POJO.response.user_controller.users_list.GetAllUsersResponseBody;
import io.restassured.response.Response;
import setup.common.helpers.TokenGenerator;
import setup.common.specification.Constants;
import specification.api.request.DeleteUserRequest;
import specification.api.request.GetUsersListRequest;

import java.util.List;

public class UserDataCleanUp {

  private final String token;

  public UserDataCleanUp() {
    this.token = tokenGenerator.getToken();
  }

  TokenGenerator tokenGenerator = new TokenGenerator
          (Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);

  GetUsersListRequest getUsersList = new GetUsersListRequest();

  DeleteUserRequest deleteRequest = new DeleteUserRequest();

  public GetAllUsersResponseBody getUsersList() {
    Response response = getUsersList.list(token);
    return response.as(GetAllUsersResponseBody.class);
  }

  public void cleanUpTestData() {
    List<Content> contentList = getUsersList().getContent();
    if (contentList.isEmpty()) {
      return;
    }
    for (Content content: contentList) {
      deleteRequest.delete(content.getId(), token);
    }
  }
}
