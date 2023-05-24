package ui;

import POJO.request.auth_controller.UserType;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import setup.ui.base.BaseFrontendTest;
@Epic("FE Tests - Admin")
@Feature("Negative tests, Role - ADMIN, Entity - User, Records")
public class AdminNegativeTests extends BaseFrontendTest {

  @Test(description = "After admin click on '+' on users page and click save on " +
          "popup window without users details entry, expecting to get validation" +
          "message")
  public void createNewUserWithEmptyFields() {
    logInPage.logInDefinedUser(UserType.ADMIN);
    adminHomePage.createNewUserWithParams("", "", "", "");
    adminHomePage.checkIfValidationMessageIsShowing("Field required.");
  }
}