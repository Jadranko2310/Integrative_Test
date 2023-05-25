package ui;

import POJO.frontend.RecordType;
import POJO.request.auth_controller.UserType;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import setup.constants.FilesConstants;
import setup.constants.RecordConstants;
import setup.ui.base.BaseFrontendTest;

@Epic("FE Tests - User")
@Feature("Functional tests, Role - USER, Entity - Records")
public class UserFunctionalTest extends BaseFrontendTest {

  @Test(description = "After user enter valid credentials on login page and clicks" +
          "login button, expecting to be navigated to home page")
  public void logInUser() {
    logInPage.logInDefinedUser(UserType.REGULAR);
    userHomePage.checkIfHomePageIsNavigated();
  }

  @Test(description = "After user click '+' on records page, populate entry fields with " +
          "valid record attributes, expecting new record to be saved in DB")
  public void createNewRecord() throws Exception {
    logInPage.logInDefinedUser(UserType.REGULAR);
    userHomePage.createJobRecord(RecordType.NEW_RECORD);
    userHomePage.checkIfNewRecordInDB(RecordType.NEW_RECORD);
  }

  @Test(description = "After user click on existing record, click on 'upload image'" +
          "button, upload image from local machine and click confirm, expecting image" +
          "to be visible in record details")
  public void editExistingRecord() throws Exception{
    logInPage.logInDefinedUser(UserType.REGULAR);
    userHomePage.updateRecordWithImage(FilesConstants.REGULAR_FILE_RELATIVE_PATH,
            RecordConstants.REGULAR_RECORD_JOB_NAME);
    userHomePage.checkIfImageOnRecordIsPresent();
  }
}