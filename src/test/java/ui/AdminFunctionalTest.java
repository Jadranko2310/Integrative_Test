package ui;

import Helpers.UserIDFromList;
import POJO.frontend.RecordType;
import POJO.request.auth_controller.UserType;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.common.constants.RecordConstants;
import setup.common.constants.UserConstants;
import setup.common.helpers.TokenGenerator;
import setup.ui.base.BaseFrontendTest;

@Epic("FE Tests - Admin")
@Feature("Functional tests, Role - ADMIN, Entity - User, Records")
public class AdminFunctionalTest extends BaseFrontendTest {

  TokenGenerator token = new TokenGenerator(UserConstants.ADMIN_EMAIL,
          UserConstants.ADMIN_PASS);
  UserIDFromList userIDFromListsersId = new UserIDFromList();

  @Test(description = "After admin clicks on side buttons, expecting to be" +
          "navigated to page for each side button")
  public void checkSideButtons() {
    logInPage.logInDefinedUser(UserType.ADMIN);
    adminHomePage.checkIfSideButtonsAreWorking();
  }

  @Test(description = "After admin click on 'Records' button, expecting to" +
          "see saved records and its details")
  public void checkIfRecordIsVisible() {
    logInPage.logInDefinedUser(UserType.ADMIN);
    adminHomePage.checkIfRecordIsPresent(RecordConstants.REGULAR_RECORD_JOB_NAME,
            RecordConstants.REGULAR_RECORD_JOB_NAME);
  }

  @Test(description = "After admin click on '+' button at users page, populate" +
          "user attributes in required fields in pop up window and click save," +
          " expecting new user to be saved in DB")
  public void createNewUser() throws Exception {
    logInPage.logInDefinedUser(UserType.ADMIN);
    adminHomePage.createNewUser(POJO.request.user_controller.UserType.FE_CREATE_USER);
    int newUserId = userIDFromListsersId.find(UserConstants.FE_USER_EMAIL,
            token.getToken());
    Assert.assertNotNull(newUserId, "User not created");
  }
  @Test(description = "After admin click on '+' button on records page, populate" +
          "record attributes on pop up window and click save, expecting new record" +
          "to be saved in DB")
  public void createNewRecord() throws Exception {
    logInPage.logInDefinedUser(UserType.ADMIN);
    adminHomePage.createNewPredefinedRecord(RecordType.ADMIN_ENTRY);
    userHomePage.checkIfNewRecordInDB(RecordType.ADMIN_ENTRY);
  }
}
