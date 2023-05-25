package ui;

import POJO.frontend.RecordType;
import POJO.request.auth_controller.UserType;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.testng.annotations.Test;
import setup.ui.base.BaseFrontendTest;

@Epic("Frontend Tests for role: User")
@Feature("Negative tests, Role: User, Entity: Records")
public class UserNegativeTests extends BaseFrontendTest {

  @Test(description = "After user click on login button on login page without entering" +
          "credentials, expecting to get validation warning message ")
  public void checkValidationOnLogInPage() {
    logInPage.logIn("", "");
    logInPage.checkValidationMessages(
            "Email required.",
            "Password required.");
  }

  @Test(description = "After user click '+' button on records page, enter invalid" +
          "record attributes in entry field and click save, expecting new record not to be" +
          "saved in DB")
  public void createNewRecordWithInvalidEntry() {
    logInPage.logInDefinedUser(UserType.REGULAR);
    userHomePage.createJobRecord(RecordType.INVALID_RECORD);
    userHomePage.checkThatNewRecordIsNotSaved(RecordType.INVALID_RECORD);
  }
}