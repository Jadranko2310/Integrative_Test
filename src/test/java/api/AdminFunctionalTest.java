package api;

import io.github.cdimascio.dotenv.Dotenv;
import org.testng.annotations.Test;
import setup.api.BaseTest;
import setup.common.specification.Constants;
import specification.api.request.LogIn;

public class AdminFunctionalTest extends BaseTest {
  LogIn logIn = new LogIn();

  @Test
  public void adminLogIn() {
    response = logIn.request(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);

    softAssert.assertEquals(response.statusCode(), 200);
  }
}
