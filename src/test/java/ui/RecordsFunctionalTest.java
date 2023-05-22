package ui;

import POJO.frontend.RecordType;
import POJO.request.auth_controller.UserType;
import org.testng.annotations.Test;
import setup.ui.base.BaseFrontendTest;

public class RecordsFunctionalTest extends BaseFrontendTest {



  @Test
  public void logInUser() {
    logInPage.logInDefinedUser(UserType.REGULAR);
    userHomePage.checkIfHomePageIsNavigated();
  }

  @Test
  public void createNewRecord() throws Exception {
    logInPage.logInDefinedUser(UserType.REGULAR);
    userHomePage.createJobRecord(RecordType.NEW_RECORD);
    userHomePage.checkIfNewRecordInDB(RecordType.NEW_RECORD);
  }
}
