package setup.common.helpers;

public class Constants {

  public static final FileControlUtil fileControlEndpoints;


  static {
    try {
      fileControlEndpoints = new FileControlUtil(FileControlUtil.ENDPOINTS);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // ENDPOINTS

  // BASE URI
  public static final String BASE_URI = fileControlEndpoints.getValue("BASE_URI");

  public static final String LOG_IN_ADMIN = fileControlEndpoints.getValue("ADMIN_LOGIN");
  

}
