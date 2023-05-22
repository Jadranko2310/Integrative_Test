package setup.ui.base;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;


/**
 * TestNG setup and actions.
 */
public class BaseTest {
  protected DriverSetup driverSetup;
  protected WebDriver driver;

  protected Url url;

  /**
   * Setting driver and url before invoked test method execution.
   */
  @BeforeMethod
  public void setupBeforeMethod() {
    driverSetup = new DriverSetup(DriverType.CHROME);
    driver = driverSetup.getDriver();
    this.url = new Url();
  }

  @AfterMethod
  public void tearDown() {
    driverSetup.closeBrowserTab();
  }

  @AfterSuite
  public void closeBrowser() {
    driverSetup.quitBrowser();
  }
}
