package specification.api.request;

import POJO.request.user_controler.User;
import io.restassured.response.Response;
import setup.api.BaseAPITest;
import setup.common.specification.Constants;

public class NewUser extends BaseAPITest {


  public Response create (String email,
                          String pass,
                          String name,
                          String phone,
                          String token) {
    User newUser = new User(email, pass, name, phone);

    return request.header("Authorization", token)
            .body(newUser)
            .post(Constants.CREATE_USER);
  }
}
