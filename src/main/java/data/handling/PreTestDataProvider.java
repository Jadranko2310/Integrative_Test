package data.handling;

import POJO.request.user_controler.User;
import org.testng.annotations.DataProvider;
import setup.common.specification.Constants;

public class PreTestDataProvider {

  @DataProvider(name = "DataPrep")
  public Object[] logInData() {
    return new Object[][]{
            {
                    new User(
                            Constants.USER_UPDATE_EMAIL,
                            Constants.USER_UPDATE_PASS,
                            Constants.USER_UPDATE_NAME,
                            Constants.USER_UPDATE_PHONE
                    )
            },
            {
                    new User(
                            Constants.USER_UPDATE_EMAIL,
                            Constants.USER_UPDATE_PASS,
                            Constants.USER_UPDATE_NAME,
                            Constants.USER_UPDATE_PHONE
                    )
            }
    };
  }
}
