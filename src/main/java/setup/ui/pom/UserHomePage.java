package setup.ui.pom;

import Helpers.AbsolutePath;
import Helpers.RecordOnList;
import POJO.frontend.CreateNewRecord;
import POJO.frontend.RecordType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import setup.common.constants.UserConstants;
import setup.common.helpers.TokenGenerator;
import setup.ui.base.DriverSetup;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.io.FileNotFoundException;

public class UserHomePage extends BasePage{
  public UserHomePage(WebDriver driver, String url) throws AWTException {
    super(driver);
    DriverSetup.navigateToUrl(driver, url);
  }

  RecordOnList findOnList = new RecordOnList();

  TokenGenerator token = new TokenGenerator(UserConstants.RECORDS_USER_EMAIL,
          UserConstants.RECORDS_USER_PASS);

  // ELEMENTS

  @FindBy(css = "svg[data-icon='setting']")
  private WebElement settingsBtn;

  @FindBy(xpath = "//div[3]/div/div/ul/li[2]/span[1]")
  private WebElement logOutBtn;

  @FindBy(css = "a[href='/users-records']")
  private WebElement records;

  @FindBy(css = "input.ant-input[placeholder='Search']")
  private WebElement searchBar;

  @FindBy(xpath = "//div/div/div/div[2]/table/tbody/tr[2]")
  private WebElement firstRecordOnList;

  @FindBy(xpath = "//div[1]/div[1]/div[1]/input")
  private WebElement jobNmbEntry;

  @FindBy(xpath = "//div/div[1]/div[2]/div[1]/input")
  private WebElement jobNameEntry;

  @FindBy(css = "span.ant-select-selection-item")
  private WebElement paymentTypeBtn;

  @FindBy(css = "div.ant-select-item-option-content")
  private WebElement companyOptionOnDropDown;

  @FindBy(xpath = "//div[1]/div[4]/div[1]/input")
  private WebElement purchaseFromEntry;

  @FindBy(xpath = "//div/div[2]/div[1]/div[1]/input")
  private WebElement purchaseDetailEntry;

  @FindBy(xpath = "//div/div[2]/div[2]/div[1]/input")
  private WebElement invoiceTotalEntry;

  @FindBy(css = "button.ant-btn.ant-btn-default.sc-jqUVSM.sc-TRNrF.kSLokU.exjpeQ")
  private WebElement createRecordBtn;

  @FindBy(css = "button.ant-btn-default")
  private WebElement uploadImageBtn;

  @FindBy(xpath = "//div[3]/div/button")
  private WebElement confirmUploadImageBtn;

  @FindBy(css = "div.ant-image-mask-info")
  private WebElement imageInRecordDetails;

  // METHODS
  public void checkIfHomePageIsNavigated(){
    waitForElementToBeClickable(records, driver);
    softAssert.assertEquals(getTextFromElement(records), "Records",
            "Text not matching");
    softAssert.assertAll("These are the issues: ");
  }

  public void createJobRecord(RecordType recordType) throws InterruptedException {
    CreateNewRecord createNewRecord = new CreateNewRecord(recordType);
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

  public void checkIfNewRecordInDB(RecordType recordType) throws Exception {
    CreateNewRecord createNewRecord = new CreateNewRecord(recordType);
    String jobName = findOnList.jobName
            (createNewRecord.getJobNmb(), token.getToken());
    softAssert.assertEquals(jobName, createNewRecord.getJobName(),
            "Job name not matching");
    softAssert.assertAll("There are the issues: ");
  }

  public void updateRecordWithImage(String filePathFromProjectDirectory,
                                    String recordName) throws FileNotFoundException, AWTException, InterruptedException {
    AbsolutePath generatePath = new AbsolutePath();
    String pathToFile = generatePath
            .generateFromRelativePath(filePathFromProjectDirectory);
    StringSelection stringSelection = new StringSelection(pathToFile);
    Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
    records.click();
    searchBar.sendKeys(recordName);
    waitForElementVisibility(firstRecordOnList, driver);
    firstRecordOnList.click();
    waitForElementToBeClickable(uploadImageBtn, driver);
    uploadImageBtn.click();
    Thread.sleep(1000);
    paste();
    hitDesktopEnter();
    waitForElementToBeClickable(confirmUploadImageBtn, driver);
    confirmUploadImageBtn.click();
  }

  public void checkIfImageOnRecordIsPresent(String recordName){
    waitForElementToBeClickable(searchBar, driver);
    searchBar.sendKeys(recordName);
    waitForElementVisibility(firstRecordOnList, driver);
    firstRecordOnList.click();
    softAssert.assertTrue(imageInRecordDetails.isDisplayed());
  }

  public void logOut(){
    waitForElementToBeClickable(settingsBtn, driver);
    settingsBtn.click();
    waitForElementToBeClickable(logOutBtn, driver);
    logOutBtn.click();
  }
}