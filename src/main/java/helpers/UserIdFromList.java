package helpers;

import POJO.response.user_controller.users_list.Content;
import POJO.response.user_controller.users_list.GetAllUsersResponseBody;
import io.restassured.response.Response;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import specification.api.request.GetUsersListRequest;

/**
 * Provides unique user id and user id list.
 */
@Getter
@Setter
public class UserIdFromList {

  GetUsersListRequest getUsersList = new GetUsersListRequest();

  private int id;

  /**
   * Generating Content list.
   */
  public List<Content> contentList(String token) {
    Response response = getUsersList.list(token);
    GetAllUsersResponseBody responseBody = response.as(GetAllUsersResponseBody.class);
    return responseBody.getContent();
  }

  /**
   * Creating list of users id.
   */
  public List<Integer> usersIdList(String token) {
    List<Content> contentList = contentList(token);
    List<Integer> userIdList = new ArrayList<>();
    for (Content content : contentList) {
      userIdList.add(content.getId());
    }
    return userIdList;
  }

  /**
   * Returning id for user with email as parameter.
   */
  public int findId(String email, String token) {
    List<Content> contentList = contentList(token);
    for (Content content : contentList) {
      if (content.getEmail().equals(email)) {
        setId(content.getId());
      }
    }
    return id;
  }
}
