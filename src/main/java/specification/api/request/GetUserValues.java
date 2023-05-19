package specification.api.request;

import io.restassured.response.Response;
import setup.api.BaseAPITest;
import setup.common.helpers.TokenGenerator;
import setup.common.specification.Constants;

public class GetUserValues extends BaseAPITest {

  public Response getListOfUsersBaseValues(String email, String pass) {
    TokenGenerator tokenGenerator = new TokenGenerator(email, pass);
    return request.header("Authorization", tokenGenerator.getToken())
            .get(Constants.ALL_USER_DETAILS);
  }
}
