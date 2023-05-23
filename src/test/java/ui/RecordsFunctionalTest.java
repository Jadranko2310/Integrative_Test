package ui;

import POJO.frontend.RecordType;
import POJO.request.auth_controller.UserType;
import org.testng.annotations.Test;
import setup.common.constants.DataConstants;
import setup.common.constants.RecordConstants;
import setup.ui.base.BaseFrontendTest;

import java.awt.*;
import java.io.FileNotFoundException;

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


  @Test
  public void editExistingRecord() throws FileNotFoundException, AWTException, InterruptedException {
    logInPage.logInDefinedUser(UserType.REGULAR);
    userHomePage.updateRecordWithImage(DataConstants.REGULAR_FILE_RELATIVE_PATH,
            RecordConstants.REGULAR_RECORD_JOB_NAME);
    userHomePage.checkIfImageOnRecordIsPresent(RecordConstants.REGULAR_RECORD_JOB_NAME);
  }
}
