package setup.ui.pom;

import POJO.request.auth_controller.LogInRequestBody;
import POJO.request.auth_controller.UserType;
import java.awt.*;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.ui.base.DriverSetup;

/**
 * Login Page web elements and methods.
 */
@Getter
@Setter
public class LogInPage extends BasePage {

  public LogInPage(WebDriver driver, String url) throws AWTException {
    super(driver);
    DriverSetup.navigateToUrl(driver, url);
  }

  // ELEMENTS SECTION

  // Buttons
  @FindBy(css = "button.sc-fctJkW.iacbkw")
  WebElement logInButton;

  // Entry fields
  @FindBy(css = "input.ant-input[placeholder='Username']")
  WebElement usernameEntryField;

  @FindBy(css = "input.ant-input[placeholder='Password']")
  WebElement passwordEntryField;

  // Validation messages
  @FindBy(xpath = "//*[text()='Email required.']")
  WebElement emailValidationMsg;

  @FindBy(xpath = "//*[text()='Password required.']")
  WebElement passValidationMsg;

  // METHODS

  // Validations
  public void checkValidationMessages(String emailValidation, String passValidation) {
    softAssert.assertEquals(emailValidation, emailValidationMsg.getText());
    softAssert.assertEquals(passValidation, passValidationMsg.getText());
    softAssert.assertAll("The validation message not as expected");
  }

  // User actions
  public void logIn(String username, String pasasword) {
    waitForElementToBeClickable(logInButton, driver);
    usernameEntryField.sendKeys(username);
    passwordEntryField.sendKeys(pasasword);
    logInButton.click();
  }

  public void logInDefinedUser(UserType type) {
    LogInRequestBody logIn = new LogInRequestBody(type);
    waitForElementToBeClickable(logInButton, driver);
    usernameEntryField.sendKeys(logIn.getEmail());
    passwordEntryField.sendKeys(logIn.getPassword());
    logInButton.click();
  }
}