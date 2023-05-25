package ui;

import helpers.UserIdFromList;
import POJO.frontend.RecordType;
import POJO.request.auth_controller.UserType;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.constants.RecordConstants;
import setup.constants.UserConstants;
import helpers.TokenGenerator;
import setup.ui.base.BaseFrontendTest;

import java.util.List;

@Epic("Frontend Test for role: Admin")
@Feature("Functional tests, Role:ADMIN, Entity: User, Records")
public class AdminFunctionalTest extends BaseFrontendTest {

  TokenGenerator token = new TokenGenerator(UserConstants.ADMIN_EMAIL,
          UserConstants.ADMIN_PASS);
  UserIdFromList userIDFromUsersList = new UserIdFromList();

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
  public void createNewUser() {
    logInPage.logInDefinedUser(UserType.ADMIN);
    adminHomePage.createNewUser(POJO.request.user_controller.UserType.FE_CREATE_USER);
    int newUserId = userIDFromUsersList.findId(
            UserConstants.FE_USER_EMAIL, token.getToken());
    List<Integer> userIdList = userIDFromUsersList.usersIdList(token.getToken());
    Assert.assertTrue(userIdList.contains(newUserId));
  }

  @Test(description = "After admin click on '+' button on records page, populate" +
          "record attributes on pop up window and click save, expecting new record" +
          "to be saved in DB")
  public void createNewRecord() throws Exception {
    logInPage.logInDefinedUser(UserType.ADMIN);
    adminHomePage.createNewPredefinedRecord(RecordType.ADMIN_ENTRY);
    userHomePage.checkIfNewRecordIsSaved(RecordType.ADMIN_ENTRY);
  }
}