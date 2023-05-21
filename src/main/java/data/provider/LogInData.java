package data.provider;

import POJO.request.auth_controler.LogInRequestBody;
import POJO.response.user_controller.login.MissingCredentialsResponseBody;
import POJO.response.user_controller.login.NotAuthorizedResponseBody;
import org.testng.annotations.DataProvider;
import setup.common.specification.Constants;

public class LogInData {


  @DataProvider(name = "LogInValidationData")
  public Object[][] logInData() {
    return new Object[][]{
            {
                    new LogInRequestBody(Constants.ADMIN_EMAIL, ""),
                    new MissingCredentialsResponseBody().Password("Field is mandatory")
            },
            {
                    new LogInRequestBody("", ""),
                    new MissingCredentialsResponseBody("Field is mandatory", "Field is mandatory")
            },
            {
                    new LogInRequestBody("", "invalidPass"),
                    new MissingCredentialsResponseBody().Email("Field is mandatory")
            },
    };
  }

  @DataProvider(name = "LogInUnauthorizedData")
  public Object[][] logInUnauthorisedData() {
    return new Object[][]{
            {
                    new LogInRequestBody(Constants.ADMIN_EMAIL, "invalidPass"),
                    new NotAuthorizedResponseBody("Invalid credentials.")

            },
            {
                    new LogInRequestBody("nouser@gmail.com", "invalidPass"),
                    new NotAuthorizedResponseBody("Unauthorized")

            },
            {
                    new LogInRequestBody(Constants.REGULAR_USER_EMAIL, "invalidPass"),
                    new NotAuthorizedResponseBody("Unauthorized")
            }
    };
  }
}
