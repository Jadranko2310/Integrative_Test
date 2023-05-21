package Helpers;

import POJO.response.user_controller.users_list.Content;
import POJO.response.user_controller.users_list.GetAllUsersResponseBody;
import lombok.Getter;
import lombok.Setter;
import setup.api.BaseAPITest;
import specification.api.request.GetUsersList;
import java.util.List;

@Getter
@Setter
public class UserIDFromList extends BaseAPITest {

  GetUsersList getUsersList = new GetUsersList();

  private int id;

    public int findUserId(String email, String token) throws Exception {
      response = getUsersList.list(token);
      GetAllUsersResponseBody responseBody = response.as(GetAllUsersResponseBody.class);
      List<Content> contentList = responseBody.getContent();
      for (Content content : contentList) {
        if (content.getEmail().equals(email)) {
           setId(content.getId());
        }
        else {
         throw new Exception("The user is not on the list");
        }
      }
      return id;
    }
}

