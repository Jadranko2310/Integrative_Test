package setup.common.constants;

public class FEConstants {

  public static final  FileControlUtil fileControlURL;

  static {
    try {
      fileControlURL = new FileControlUtil(FileControlUtil.FE_URL);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // SELENIUM BASE CONFIGURATION
  public static final int ELEMENT_DETECTION_TIMEOUT = 15;
  public static final int PAGE_LOAD_TIME = 15;

  // FE URLs
  public static final String BASE_URL =
          fileControlURL.getValue("BASE_URL");
  public static final String LOG_IN_PAGE =
          fileControlURL.getValue("LOG_IN_PAGE");
  public static final String USERS_HOME_PAGE
          = fileControlURL.getValue("USERS_HOME_PAGE");

  public static final String USERS_RECORDS_PAGE =
          fileControlURL.getValue("USERS_RECORDS_PAGE");
}
