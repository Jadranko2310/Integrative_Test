package specification.api.request;

import io.restassured.response.Response;
import setup.api.BaseAPITest;
import setup.common.specification.Constants;

public class GetUsersList extends BaseAPITest {

  public Response list(String token) {
    return request.header("Authorization", token)
            .param("page", 0)
            .param("pageSize", 10)
            .param("filterColumn", "all")
            .param("orderColumn", "name")
            .param("orderValue", "ascend")
            .get(Constants.ALL_USERS);
  }
}
