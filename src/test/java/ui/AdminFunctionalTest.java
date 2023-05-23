package ui;

import Helpers.UserIDFromList;
import POJO.request.auth_controller.UserType;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.common.constants.RecordConstants;
import setup.common.constants.UserConstants;
import setup.common.helpers.TokenGenerator;
import setup.ui.base.BaseFrontendTest;

public class AdminFunctionalTest extends BaseFrontendTest {

  TokenGenerator token = new TokenGenerator(UserConstants.ADMIN_EMAIL,
          UserConstants.ADMIN_PASS);
  UserIDFromList userIDFromListsersId = new UserIDFromList();

  @Test
  public void checkIfRecordIsVisible() {
    logInPage.logInDefinedUser(UserType.ADMIN);
    adminHomePage.checkIfRecordIsPresent(RecordConstants.REGULAR_RECORD_JOB_NAME,
            RecordConstants.REGULAR_RECORD_JOB_NAME);
  }

  @Test
  public void createNewUser() throws Exception {
    logInPage.logInDefinedUser(UserType.ADMIN);
    adminHomePage.createNewUser(POJO.request.user_controller.UserType.FE_CREATE_USER);
    int newUserId = userIDFromListsersId.find(UserConstants.FE_USER_EMAIL,
            token.getToken());
    Assert.assertNotNull(newUserId, "User not created");
  }
}
