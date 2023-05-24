package ui;

import POJO.frontend.RecordType;
import POJO.request.auth_controller.UserType;
import org.testng.annotations.Test;
import setup.ui.base.BaseFrontendTest;

public class UserNegativeTests extends BaseFrontendTest {

  @Test
  public void checkValidationOnLogInPage() {
    logInPage.logIn("", "");
    logInPage.checkValidation(
            "Email required.",
            "Password required.");
  }

  @Test
  public void createNewUserWithInvalidEntry() throws Exception {
    logInPage.logInDefinedUser(UserType.REGULAR);
    userHomePage.createJobRecord(RecordType.INVALID_RECORD);
    userHomePage.checkThatNewRecordIsNotInDB(RecordType.INVALID_RECORD);
  }
}
