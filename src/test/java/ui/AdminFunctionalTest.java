package ui;

import POJO.request.auth_controller.UserType;
import org.testng.annotations.Test;
import setup.common.constants.RecordConstants;
import setup.ui.base.BaseFrontendTest;

public class AdminFunctionalTest extends BaseFrontendTest {

  @Test
  public void checkIfRecordIsVisible() {
    logInPage.logInDefinedUser(UserType.ADMIN);
    adminHomePage.checkIfRecordIsPresent(RecordConstants.REGULAR_RECORD_JOB_NAME,
            RecordConstants.REGULAR_RECORD_JOB_NAME);
  }

  @Test
  public void createNewUser() {
    logInPage.logInDefinedUser(UserType.ADMIN);
    adminHomePage.createNewUser(POJO.request.user_controller.UserType.FE_CREATE_USER);
  }
}
