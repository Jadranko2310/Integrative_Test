package setup.ui.pom;

import POJO.frontend.NewRecord;
import POJO.frontend.RecordType;
import POJO.request.user_controller.User;
import POJO.request.user_controller.UserType;
import org.openqa.selenium.By;
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
  @FindBy(css = "span.ant-menu-title-content > a[href='/admins']")
  private WebElement adminsSideBtn;
  @FindBy(css = "span.ant-menu-title-content > a[href='/users']")
  private WebElement usersSideBtn;

  @FindBy(css = "span.ant-menu-title-content > a[href='/suppliers']")
  private WebElement suppliersSideBtn;

  @FindBy(css = "div.sc-cCsOjp.bQQQsz")
  private WebElement adminsPageHeadline;

  @FindBy(css = "div.sc-fytwQQ.iKqmUd")
  private WebElement usersPageHeadLine;

  @FindBy(css = "div.sc-hKpBwk.kvUaca")
  private WebElement supplierPageHeadline;

 @FindBy(css = "div.sc-dSuTWQ.hIKYzE")
 private WebElement recordsPageHeadline;
 @FindBy(css = "span.ant-menu-title-content > a[href='/records']")
 private WebElement recordsSideBtn;

  @FindBy(xpath = "//div/div[1]/div[1]/div[2]/div/span[2]")
  private WebElement selectUserBtn;

  @FindBy(css = "div.ant-select-item-option-content")
  private WebElement selectFirstUser;

  @FindBy(xpath = "//form/div[1]/div/div[2]/div[1]/input")
  private WebElement jobNumberEntryField;

  @FindBy(xpath = "//div[1]/div/div[3]/div[1]/input")
  private WebElement jobNameEntryField;

  @FindBy(xpath = "//div/div[4]/div[1]/div[2]/div/span[2]")
  private WebElement paymentTypeBtn;

  @FindBy(xpath = "//div[4]/div/div/div/div[2]/div[1]/div/div/div[3]/div")
  private WebElement companyAccSelection;

  @FindBy(xpath = "//form/div[1]/div/div[5]/div[1]/input")
  private WebElement purchasedFromEntryField;

  @FindBy(xpath = "//div[1]/div/div[6]/div[1]/input")
  private WebElement purchaseDetailEntryField;

  @FindBy(xpath = "//div/div[7]/div[1]/input")
  private WebElement invoiceTotalEntryField;

  @FindBy(css = "button.ant-btn.ant-btn-default.sc-jqUVSM.sc-bjUoiL.kSLokU.kHYOWb")
  private WebElement confirm;


  @FindBy(css = "input.ant-input.sc-kngDgl.frWszN.input[type=text]")
  private WebElement searchBar;

  @FindBy(css = "button.ant-btn.ant-btn-default.ant-btn-icon-only.sc-jqUVSM.sc-bZkfAO.kSLokU.kmmRVV")
  private WebElement addUserButton;

  @FindBy(css = "button.ant-btn.ant-btn-default.ant-btn-icon-only")
  private WebElement addRecordBtn;

  @FindBy(xpath = "//form/div[1]/div/div[1]/div[1]/input")
  private WebElement emailEntryField;

  @FindBy(xpath = "//form/div[1]/div/div[2]/div[1]/input")
  private WebElement passEntryField;

  @FindBy(xpath = "//form/div[1]/div/div[3]/div[1]/input")
  private WebElement nameEntryField;

  @FindBy(xpath = "//div/div[4]/div[1]/input")
  private WebElement phoneEntryFiled;

  @FindBy(css = "div.sc-evZas.bdrJDj")
  private WebElement validationMsg;

  @FindBy(css = "button.ant-btn.ant-btn-default.sc-jqUVSM.sc-bjUoiL.kSLokU.kHYOWb")
  private WebElement confirmBtn;

  @FindBy(css = "td.ant-table-cell")
  private WebElement firstRecordOnList;

 /* @FindBy(xpath = "//div[2]/div[2]/div/div/div[1]/div[4]")
  private WebElement jobNameOnRecordDetailsWindow;*/

  public WebElement jobNameOnRecordDetailsWindow(String value) {
    return driver.findElement(By.xpath(
            "//div[contains(@class, 'sc-dWINGa') and contains" +
                    "(@class, 'dkoBEN') and contains(text(), '" + value + "')]"));
  }


  // METHOD SECTION

  public void checkIfSideButtonsAreWorking(){
    waitForElementToBeClickable(adminsSideBtn, driver);
    adminsSideBtn.click();
    softAssert.assertEquals(adminsPageHeadline.getText(), "Admins");
    waitForElementToBeClickable(usersSideBtn, driver);
    usersSideBtn.click();
    softAssert.assertEquals(usersPageHeadLine.getText(), "Users");
    waitForElementToBeClickable(suppliersSideBtn, driver);
    suppliersSideBtn.click();
    softAssert.assertEquals(supplierPageHeadline.getText(), "Suppliers");
    waitForElementToBeClickable(recordsSideBtn, driver);
    recordsSideBtn.click();
    softAssert.assertEquals(recordsPageHeadline.getText(), "Records");
    softAssert.assertAll();
  }

  public void checkIfRecordIsPresent(String recordName, String jobNameToCompare) {
    waitForElementToBeClickable(recordsSideBtn, driver);
    recordsSideBtn.click();
    waitForElementToBeClickable(searchBar, driver);
    searchBar.sendKeys(recordName);
    firstRecordOnList.click();
    waitForElementVisibility
            (jobNameOnRecordDetailsWindow(jobNameToCompare), driver);
    softAssert.assertEquals
            (jobNameOnRecordDetailsWindow(jobNameToCompare).getText(), jobNameToCompare,
            "Job name is not matching");
    softAssert.assertAll("These are the issues: ");
  }

  public void createNewUser(UserType userType) {
    User user = new User(userType);
    waitForElementToBeClickable(usersSideBtn, driver);
    usersSideBtn.click();
    waitForElementToBeClickable(addUserButton, driver);
    addUserButton.click();
    waitForElementToBeClickable(emailEntryField, driver);
    emailEntryField.sendKeys(user.getEmail());
    passEntryField.sendKeys(user.getPassword());
    nameEntryField.sendKeys(user.getName());
    phoneEntryFiled.sendKeys(user.getPhone());
    waitForElementToBeClickable(confirmBtn, driver);
    confirmBtn.click();
  }

  public void createNewUserWithParams(String email,
                                      String pass,
                                      String name,
                                      String phone) {
    waitForElementToBeClickable(usersSideBtn, driver);
    usersSideBtn.click();
    waitForElementToBeClickable(addUserButton, driver);
    addUserButton.click();
    waitForElementToBeClickable(emailEntryField, driver);
    waitForElementToBeClickable(emailEntryField, driver);
    emailEntryField.sendKeys(email);
    passEntryField.sendKeys(pass);
    nameEntryField.sendKeys(name);
    phoneEntryFiled.sendKeys(phone);
    waitForElementToBeClickable(confirmBtn, driver);
    confirmBtn.click();
  }

  public void checkIfValidationMessageIsShowing(String validationMessage) {
    softAssert.assertEquals(validationMessage, validationMsg.getText());
    softAssert.assertAll("These are the issues: ");
  }

  public void createRecordForRegularUser(String jobNmb, String jobName,
                                         String purchaseFrom, String purchaseDetail,
                                         String invoiceTotal) {
    waitForElementToBeClickable(recordsSideBtn, driver);
    recordsSideBtn.click();
    waitForElementToBeClickable(addRecordBtn, driver);
    addRecordBtn.click();
    waitForElementToBeClickable(selectUserBtn, driver);
    selectUserBtn.click();
    waitForElementToBeClickable(selectFirstUser, driver);
    selectFirstUser.click();
    jobNumberEntryField.sendKeys(jobNmb);
    jobNameEntryField.sendKeys(jobName);
    purchasedFromEntryField.sendKeys(purchaseFrom);
    purchaseDetailEntryField.sendKeys(purchaseDetail);
    invoiceTotalEntryField.sendKeys(invoiceTotal);
    confirmBtn.click();
  }

  public void createNewPredefinedRecord(RecordType recordType) throws InterruptedException {
    NewRecord record = new NewRecord(recordType);
    waitForElementToBeClickable(recordsSideBtn, driver);
    recordsSideBtn.click();
    waitForElementToBeClickable(addRecordBtn, driver);
    addRecordBtn.click();
    waitForElementToBeClickable(selectUserBtn, driver);
    selectUserBtn.click();
    waitForElementToBeClickable(selectFirstUser, driver);
    selectFirstUser.click();
    jobNumberEntryField.sendKeys(record.getJobNmb());
    jobNameEntryField.sendKeys(record.getJobName());
    waitForElementToBeClickable(paymentTypeBtn, driver);
    paymentTypeBtn.click();
    waitForElementToBeClickable(companyAccSelection, driver);
    companyAccSelection.click();
    purchasedFromEntryField.sendKeys(record.getPurchaseFrom());
    purchaseDetailEntryField.sendKeys(record.getPurchaseDetail());
    invoiceTotalEntryField.sendKeys(String.valueOf(record.getInvoiceTotal()));
    waitForElementToBeClickable(confirmBtn, driver);
    Thread.sleep(3000);
    confirmBtn.click();
  }
}
