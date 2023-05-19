package specification.api.request;

import io.restassured.response.Response;
import setup.api.BaseAPITest;
import setup.common.helpers.TokenGenerator;
import setup.common.specification.Constants;

public class GetUserValues extends BaseAPITest {

  public Response getListOfUsersBaseValues(String token) {
    return request.header("Authorization", token)
            .get(Constants.ALL_USER_DETAILS);
  }
}
