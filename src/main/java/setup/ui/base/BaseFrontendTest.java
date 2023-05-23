package setup.ui.base;

import data.handling.RecordsDataHandler;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import setup.common.constants.FEConstants;
import setup.ui.pom.LogInPage;
import setup.ui.pom.UserHomePage;

import java.awt.*;

/**
 * TestNG setup and actions.
 */
public class BaseFrontendTest {
  protected DriverSetup driverSetup;
  protected WebDriver driver;

  protected LogInPage logInPage;

  protected UserHomePage userHomePage;

  RecordsDataHandler recordsDataHandler = new RecordsDataHandler();

  /**
   * Setting driver and url before invoked test method execution.
   */

  @BeforeSuite
  public void prepareDataForTesting() throws Exception {
    recordsDataHandler.prepareData();
  }

  @BeforeMethod
  public void setupBeforeMethod() throws AWTException {
    driverSetup = new DriverSetup(DriverType.CHROME);
    driver = driverSetup.getDriver();
    logInPage = new LogInPage(driver, FEConstants.LOG_IN_PAGE);
    userHomePage = new UserHomePage(driver, FEConstants.USERS_HOME_PAGE);
  }

  @AfterMethod
  public void tearDown() {
    driverSetup.closeBrowserTab();
  }

  @AfterSuite
  public void closeBrowser() {
    driverSetup.quitBrowser();
    recordsDataHandler.cleanData();
  }
}