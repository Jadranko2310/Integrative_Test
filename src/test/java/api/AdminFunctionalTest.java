package api;

import POJO.response.login.LogInResponseBody;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.api.BaseAPITest;
import setup.common.specification.Constants;
import specification.api.request.LogIn;

public class AdminFunctionalTest extends BaseAPITest {
  LogIn logIn = new LogIn();

  @Test
  public void adminLogIn() {
    response = logIn.request(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
    LogInResponseBody responseBody = response.getBody().as(LogInResponseBody.class);

    softAssert.assertEquals(response.statusCode(), 200);
    softAssert.assertEquals(responseBody.getUser().getUserGroup().getId(), 1);

  }
}
