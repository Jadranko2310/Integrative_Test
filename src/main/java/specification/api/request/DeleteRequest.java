package specification.api.request;

import io.restassured.response.Response;
import setup.api.BaseAPITest;
import setup.common.specification.Constants;

public class DeleteRequest extends BaseAPITest {

  public Response delete(int userID, String token) {
    return request
            .header("Authorization", token)
            .delete(Constants.DELETE_USER + userID);
  }
}
