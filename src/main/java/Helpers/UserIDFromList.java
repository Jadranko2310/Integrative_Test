package Helpers;

import POJO.response.user_controller.users_list.Content;
import POJO.response.user_controller.users_list.GetAllUsersResponseBody;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import specification.api.request.GetUsersListRequest;
import java.util.List;

@Getter
@Setter
public class UserIDFromList {

  GetUsersListRequest getUsersList = new GetUsersListRequest();

  private int id;

    public int find (String email, String token) throws Exception {
      Response response = getUsersList.list(token);
      GetAllUsersResponseBody responseBody = response.as(GetAllUsersResponseBody.class);
      List<Content> contentList = responseBody.getContent();
      for (Content content : contentList) {
        if (content.getEmail().equals(email)) {
           setId(content.getId());
        }
      }
      return id;
    }
}

