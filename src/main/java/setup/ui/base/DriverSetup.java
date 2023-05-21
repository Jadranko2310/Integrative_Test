package setup.ui.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import setup.common.constants.FEConstants;
import setup.common.constants.UserConstants;

import java.time.Duration;


/**
 * Driver properties.
 */
@Getter
@Setter
public class DriverSetup {

  private WebDriver driver;

  /**
   * *  Setup based on browser type.
   */
  public DriverSetup(DriverType driverType) {

    switch (driverType) {
      case CHROME -> {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        this.driver = new ChromeDriver(options);
      }
      case FIREFOX -> {
        WebDriverManager.chromedriver().setup();
        this.driver = new FirefoxDriver();
      }
      default -> throw new RuntimeException("The browser type incorrect");
    }
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
  }

  /**
   * Will navigate to defined URL with predefined page load time and implicit wait.
   */
  public static void navigateToUrl(WebDriver driver, String url) {
    driver.manage().timeouts()
            .pageLoadTimeout(Duration.ofSeconds(FEConstants.PAGE_LOAD_TIME));
    driver.manage().timeouts()
            .implicitlyWait(Duration.ofSeconds(FEConstants.ELEMENT_DETECTION_TIMEOUT));
    driver.get(url);
  }

  public void closeBrowserTab() {
    driver.close();
  }

  public void quitBrowser() {
    driver.quit();
  }
}
