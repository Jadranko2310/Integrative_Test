package ui;

import POJO.request.auth_controller.UserType;
import org.testng.annotations.Test;
import setup.ui.base.BaseFrontendTest;

public class AdminNegativeTests extends BaseFrontendTest {

  @Test
  public void createNewUserWithEmptyFields() {
    logInPage.logInDefinedUser(UserType.ADMIN);
    adminHomePage.createNewUserWithParams("", "", "", "");
    adminHomePage.checkIfValidationMessageIsShowing("Field required.");
  }
}
