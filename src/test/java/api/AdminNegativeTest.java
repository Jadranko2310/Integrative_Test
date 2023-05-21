package api;

import POJO.request.auth_controler.LogInRequestBody;
import POJO.response.user_controller.login.MissingCredentialsResponseBody;
import POJO.response.user_controller.login.NotAuthorizedResponseBody;
import data.provider.LogInData;
import org.testng.annotations.Test;
import setup.api.BaseAPITest;
import setup.common.helpers.TokenGenerator;
import setup.common.specification.Constants;
import specification.api.request.LogInRequest;

public class AdminNegativeTest extends BaseAPITest {
  TokenGenerator token = new TokenGenerator(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
  LogInRequest logIn = new LogInRequest();


  @Test(dataProvider = "LogInValidationData", dataProviderClass = LogInData.class)
  public void logInWIthMissingCredentials(LogInRequestBody requestBody,
                                          MissingCredentialsResponseBody expectingResponseBody) {
    response = logIn.request(requestBody.getEmail(), requestBody.getPassword());
    MissingCredentialsResponseBody actualResponseBody =
            response.getBody().as(MissingCredentialsResponseBody.class);

    softAssert.assertEquals(response.statusCode(), 400,
            "Status code not as expected");
    softAssert.assertEquals(expectingResponseBody.email, actualResponseBody.email,
            "Email message not as expected");
    softAssert.assertEquals(expectingResponseBody.password, actualResponseBody.password,
            "Password not as expected");
    softAssert.assertAll("There are the issues: ");
  }

  @Test(dataProvider = "LogInUnauthorizedData", dataProviderClass = LogInData.class)
  public void UnauthorizedLogIn(LogInRequestBody requestBody,
                                NotAuthorizedResponseBody expectedResponseBody) {
    response = logIn.request(requestBody.getEmail(), requestBody.getPassword());
    NotAuthorizedResponseBody actualResponseBody =
            response.as(NotAuthorizedResponseBody.class);
    softAssert.assertEquals(expectedResponseBody.getMessage(),
            actualResponseBody.getMessage(),
            "Response message not as expected");
  }
}
