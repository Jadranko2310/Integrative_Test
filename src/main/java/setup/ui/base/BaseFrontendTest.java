package setup.ui.base;

import data.handling.RecordsDataHandler;
import java.awt.*;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import setup.constants.FrontendConstants;
import setup.ui.pom.AdminHomePage;
import setup.ui.pom.LogInPage;
import setup.ui.pom.UserHomePage;


/**
 * TestNG setup and actions.
 */
public class BaseFrontendTest {
  protected DriverSetup driverSetup;
  protected WebDriver driver;
  protected LogInPage logInPage;
  protected UserHomePage userHomePage;
  protected AdminHomePage adminHomePage;
  RecordsDataHandler recordsDataHandler = new RecordsDataHandler();

  /**
   * Setting driver and url before invoked test method execution.
   */

  @BeforeSuite
  public void prepareDataForTesting() throws Exception {
    recordsDataHandler.cleanData();
    recordsDataHandler.prepareData();
  }

  @BeforeMethod
  public void setupBeforeMethod() throws AWTException {
    driverSetup = new DriverSetup(DriverType.CHROME);
    driver = driverSetup.getDriver();
    logInPage = new LogInPage(driver, FrontendConstants.LOG_IN_PAGE);
    userHomePage = new UserHomePage(driver, FrontendConstants.USERS_HOME_PAGE);
    adminHomePage = new AdminHomePage(driver, FrontendConstants.ADMIN_HOME_PAGE);
  }

  @AfterMethod
  public void tearDown() {
    driverSetup.closeBrowserTab();
  }

  /**
   * Clearing test data after TestNG run suite.
   */
  @AfterSuite
  public void closeBrowserAndClearData() {
    driverSetup.quitBrowser();
    recordsDataHandler.cleanData();
  }
}