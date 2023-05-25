package setup.ui.pom;

import POJO.frontend.NewRecord;
import POJO.frontend.RecordType;
import helpers.AbsolutePath;
import helpers.RecordOnList;
import helpers.TokenGenerator;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.constants.UserConstants;
import setup.ui.base.DriverSetup;

/**
 * Users home page web elements and methods.
 */
public class UserHomePage extends BasePage {
  public UserHomePage(WebDriver driver, String url) throws AWTException {
    super(driver);
    DriverSetup.navigateToUrl(driver, url);
  }

  RecordOnList findOnList = new RecordOnList();

  TokenGenerator token = new TokenGenerator(UserConstants.RECORDS_USER_EMAIL,
          UserConstants.RECORDS_USER_PASS);

  // ELEMENTS

  // Buttons
  @FindBy(css = "svg[data-icon='setting']")
  private WebElement settingsBtn;
  @FindBy(css = "span.anticon.anticon-logout")
  private WebElement logOutBtn;
  @FindBy(css = "a[href='/users-records']")
  private WebElement recordsButton;
  @FindBy(css = "span.ant-select-selection-item")
  private WebElement paymentTypeBtn;
  @FindBy(css = "button.ant-btn.ant-btn-default.sc-jqUVSM.sc-TRNrF.kSLokU.exjpeQ")
  private WebElement createRecordBtn;
  @FindBy(css = "button.ant-btn-default")
  private WebElement uploadImageBtn;
  @FindBy(xpath = "//*[text()='Confirm']")
  private WebElement confirmUploadImageBtn;

  // Drop down
  @FindBy(css = "div.ant-select-item-option-content")
  private WebElement companyOptionOnDropDown;

  // Entry field
  @FindBy(xpath = "//div[1]/div[1]/div[1]/input")
  private WebElement jobNmbEntry;
  @FindBy(xpath = "//div/div[1]/div[2]/div[1]/input")
  private WebElement jobNameEntry;
  @FindBy(xpath = "//div[1]/div[4]/div[1]/input")
  private WebElement purchaseFromEntry;
  @FindBy(xpath = "//div/div[2]/div[1]/div[1]/input")
  private WebElement purchaseDetailEntry;
  @FindBy(xpath = "//div/div[2]/div[2]/div[1]/input")
  private WebElement invoiceTotalEntry;

  // Select from dop down elements
  @FindBy(css = "td.ant-table-cell")
  private WebElement firstRecordOnList;

  // Search bar
  @FindBy(css = "input.ant-input[placeholder='Search']")
  private WebElement searchBar;

  // Text
  @FindBy(css = "span.anticon.anticon-eye")
  private WebElement imageInRecordDetails;


  // METHODS
  // Validations
  public void checkIfHomePageIsNavigated() {
    waitForElementToBeClickable(recordsButton, driver);
    softAssert.assertEquals(getTextFromElement(recordsButton), "Records",
            "Text not matching");
    softAssert.assertAll("These are the issues: ");
  }

  public void checkIfNewRecordIsSaved(RecordType recordType) {
    NewRecord createNewRecord = new NewRecord(recordType);
    String jobName = findOnList.jobName(
            createNewRecord.getJobNmb(), token.getToken());
    softAssert.assertEquals(jobName, createNewRecord.getJobName(),
            "Job name not matching");
    softAssert.assertAll("There are the issues: ");
  }

  public void checkThatNewRecordIsNotSaved(RecordType recordType) {
    NewRecord createNewRecord = new NewRecord(recordType);
    String jobName = findOnList.jobName(
            createNewRecord.getJobNmb(), token.getToken());
    softAssert.assertEquals(jobName, null,
            "There are some issues in validation, new record in DB");
    softAssert.assertAll("There are the issues: ");
  }

  public void checkIfImageOnRecordIsPresent() {
    waitForElementToBeClickable(searchBar, driver);
    waitForElementVisibility(firstRecordOnList, driver);
    firstRecordOnList.click();
    softAssert.assertTrue(imageInRecordDetails.isDisplayed());
  }

  // Making changes in DB
  public void createJobRecord(RecordType recordType) {
    NewRecord createNewRecord = new NewRecord(recordType);
    jobNmbEntry.sendKeys(createNewRecord.getJobNmb());
    jobNameEntry.sendKeys(createNewRecord.getJobName());
    paymentTypeBtn.click();
    waitForElementToBeClickable(companyOptionOnDropDown, driver);
    companyOptionOnDropDown.click();
    purchaseFromEntry.sendKeys(createNewRecord.getPurchaseFrom());
    purchaseDetailEntry.sendKeys(createNewRecord.getPurchaseDetail());
    invoiceTotalEntry.sendKeys(String.valueOf(createNewRecord.getInvoiceTotal()));
    createRecordBtn.click();
  }

  public void updateRecordWithImage(String filePathFromProjectDirectory,
                                    String recordName) throws Exception {
    AbsolutePath generatePath = new AbsolutePath();
    String pathToFile = generatePath
            .generateFromRelativePath(filePathFromProjectDirectory);
    StringSelection stringSelection = new StringSelection(pathToFile);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    recordsButton.click();
    searchBar.sendKeys(recordName);
    waitForElementVisibility(firstRecordOnList, driver);
    firstRecordOnList.click();
    waitForElementToBeClickable(uploadImageBtn, driver);
    uploadImageBtn.click();
    Thread.sleep(1000);
    paste();
    hitDesktopEnter();
    Thread.sleep(700); // To be done: adding explicit wait after css is fixed
    waitForElementVisibility(confirmUploadImageBtn, driver);
    confirmUploadImageBtn.click();
  }

  // Actions
  public void logOut() {
    waitForElementToBeClickable(settingsBtn, driver);
    settingsBtn.click();
    waitForElementToBeClickable(logOutBtn, driver);
    logOutBtn.click();
  }
}
