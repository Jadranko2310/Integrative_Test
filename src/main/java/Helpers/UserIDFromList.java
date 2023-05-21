package Helpers;

import POJO.response.user_controller.users_list.Content;
import POJO.response.user_controller.users_list.GetAllUsersResponseBody;
import lombok.Getter;
import lombok.Setter;
import setup.api.BaseAPITest;
import specification.api.request.GetUsersListRequest;
import java.util.List;

@Getter
@Setter
public class UserIDFromList extends BaseAPITest {

  GetUsersListRequest getUsersList = new GetUsersListRequest();

  private int id;

    public int findUserId(String email, String token) throws Exception {
      response = getUsersList.list(token);
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

