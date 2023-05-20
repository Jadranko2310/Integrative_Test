package specification.api.request;

import POJO.request.user_controler.User;
import io.restassured.response.Response;
import setup.api.BaseAPITest;
import setup.common.specification.Constants;

public class NewUser extends BaseAPITest {


  public Response create (User user, String token) {
    return request.header("Authorization", token)
            .body(user)
            .post(Constants.CREATE_USER);
  }
}
