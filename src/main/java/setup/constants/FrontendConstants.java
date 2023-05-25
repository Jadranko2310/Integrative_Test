package setup.constants;

import helpers.FileControlUtil;

/**
 * Constants used for frontend tests.
 */
public class FrontendConstants {

  public static final FileControlUtil fileControlURL;

  static {
    try {
      fileControlURL = new FileControlUtil(FileControlUtil.FE_URL);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // SELENIUM BASE CONFIGURATION
  public static final int ELEMENT_DETECTION_TIMEOUT = 10;
  public static final int PAGE_LOAD_TIME = 15;

  // FRONTEND URL's
  public static final String BASE_URL =
          fileControlURL.getValue("BASE_URL");
  public static final String LOG_IN_PAGE =
          fileControlURL.getValue("LOG_IN_PAGE");
  public static final String USERS_HOME_PAGE
          = fileControlURL.getValue("USERS_HOME_PAGE");

  public static final String USERS_RECORDS_PAGE =
          fileControlURL.getValue("USERS_RECORDS_PAGE");

  public static final String ADMIN_HOME_PAGE =
          fileControlURL.getValue("ADMIN_HOME_PAGE");
}