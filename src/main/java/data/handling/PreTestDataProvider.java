package data.handling;

import POJO.request.user_controller.User;
import org.testng.annotations.DataProvider;
import setup.constants.UserConstants;

public class PreTestDataProvider {

  @DataProvider(name = "DataPrep")
  public Object[] logInData() {
    return new Object[][]{
            {
                    new User(
                            UserConstants.USER_UPDATE_EMAIL,
                            UserConstants.USER_UPDATE_PASS,
                            UserConstants.USER_UPDATE_NAME,
                            UserConstants.USER_UPDATE_PHONE
                    )
            },
            {
                    new User(
                            UserConstants.USER_UPDATE_EMAIL,
                            UserConstants.USER_UPDATE_PASS,
                            UserConstants.USER_UPDATE_NAME,
                            UserConstants.USER_UPDATE_PHONE
                    )
            }
    };
  }
}
