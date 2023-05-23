package ui;

import org.testng.annotations.Test;
import setup.ui.base.BaseFrontendTest;

public class RecordsNegativeTests extends BaseFrontendTest {

  @Test
  public void checkValidationOnLogInPage() {
    logInPage.logIn("", "");
    logInPage.checkValidation(
            "Email required.",
            "Password required.");
  }
}
