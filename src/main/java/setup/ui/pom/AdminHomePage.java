package setup.ui.pom;

import POJO.request.user_controller.User;
import POJO.request.user_controller.UserType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.ui.base.DriverSetup;

import java.awt.*;

public class AdminHomePage extends BasePage{
  public AdminHomePage(WebDriver driver, String url) throws AWTException {
    super(driver);
    DriverSetup.navigateToUrl(driver, url);
  }


  // ELEMENTS SECTION
  @FindBy(css = "span.ant-menu-title-content > a[href='/records']")
  private WebElement records;

  @FindBy(xpath = "//section/aside/div[1]/ul/li[3]/span[2]")
  private WebElement users;

  @FindBy(css = "input.ant-input.sc-kngDgl.frWszN.input[type=text]")
  private WebElement searchBar;

  @FindBy(css = "button.ant-btn.ant-btn-default.ant-btn-icon-only.sc-jqUVSM.sc-bZkfAO.kSLokU.kmmRVV")
  private WebElement addButton;

  @FindBy(xpath = "//form/div[1]/div/div[1]/div[1]/input")
  private WebElement emailEntryField;

  @FindBy(xpath = "//form/div[1]/div/div[2]/div[1]/input")
  private WebElement passEntryField;

  @FindBy(xpath = "//form/div[1]/div/div[3]/div[1]/input")
  private WebElement nameEntryField;

  @FindBy(xpath = "//div/div[4]/div[1]/input")
  private WebElement phoneEntryFiled;

  @FindBy(css = "button.ant-btn.ant-btn-default.sc-jqUVSM.sc-bjUoiL.kSLokU.kHYOWb")
  private WebElement confirmBtn;

  @FindBy(xpath = "//div/div[2]/table/tbody/tr[2]")
  private WebElement firstRecordOnList;

  @FindBy(xpath = "//div[2]/div[2]/div/div/div[1]/div[4]")
  private WebElement jobName;

  // METHOD SECTION

  public void checkIfRecordIsPresent(String recordName, String jobNameToCompare) {
    waitForElementToBeClickable(records, driver);
    records.click();
    waitForElementToBeClickable(searchBar, driver);
    searchBar.sendKeys(recordName);
    firstRecordOnList.click();
    waitForElementVisibility(jobName, driver);
    softAssert.assertEquals(jobName.getText(), jobNameToCompare,
            "Job name is not matching");
    softAssert.assertAll("These are the issues: ");
  }

  public void createNewUser(UserType userType) {
    User user = new User(userType);
    waitForElementToBeClickable(users, driver);
    users.click();
    waitForElementToBeClickable(addButton, driver);
    addButton.click();
    waitForElementToBeClickable(emailEntryField, driver);
    emailEntryField.sendKeys(user.getEmail());
    passEntryField.sendKeys(user.getPassword());
    nameEntryField.sendKeys(user.getPassword());
    phoneEntryFiled.sendKeys(user.getPhone());
    waitForElementToBeClickable(confirmBtn, driver);
    confirmBtn.click();
  }

  public void checkIfUserIsInDB() {

  }
}
