package setup.common.specification;
import io.github.cdimascio.dotenv.Dotenv;

/**
 * Defining all constants needed for project:
 * BE endpoints
 * FE URLS
 * User credentials
 */
public class Constants {

  static {
    try {
      /*fileControlEndpoints = new FileControlUtil(FileControlUtil.ENDPOINTS);*/
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  static Dotenv dotenv = Dotenv.configure().load();

  // ENDPOINTS
  public static final String BASE_URI = dotenv.get("BASE_URI");
  // AUTHORIZATION CONTROLLER
  public static final String LOG_IN = dotenv.get("LOGIN");

  // USER CONTROLLER
  public static final String ALL_USERS = dotenv.get("ALL_USERS");
  public static final String CREATE_USER = dotenv.get("CREATE_USER");
  public static final String DELETE_USER = dotenv.get("DELETE_USER");


  // USER CREDENTIALS
  public static final String REGULAR_USER_EMAIL = dotenv.get("REGULAR_USER_EMAIL");
  public static final String REGULAR_USER_PASS = dotenv.get("REGULAR_USER_PASS");
  public static final String REGULAR_USER_NAME = dotenv.get("REGULAR_USER_NAME");
  public static final String REGULAR_USER_PHONE = dotenv.get("REGULAR_USER_PHONE");
  // Invalid
  public static final String INVALID_EMAIL = dotenv.get("INVALID_EMAIL");
  public static final String INVALID_PASS = dotenv.get("INVALID_PASS");
  public static final String INVALID_NAME = dotenv.get("INVALID_NAME");
  public static final String INVALID_PHONE = dotenv.get("INVALID_PHONE");
  // PREP DETAILS
  // User - update
  public static final String USER_UPDATE_EMAIL = dotenv.get("USER_UPDATE_EMAIL");
  public static final String USER_UPDATE_PASS = dotenv.get("USER_UPDATE_PASS");
  public static final String USER_UPDATE_NAME = dotenv.get("USER_UPDATE_NAME");
  public static final String USER_UPDATE_PHONE = dotenv.get("USER_UPDATE_PHONE");
  // User delete
  public static final String USER_DELETE_EMAIL = dotenv.get("USER_DELETE_EMAIL");
  public static final String USER_DELETE_PASS = dotenv.get("USER_DELETE_PASS");
  public static final String USER_DELETE_NAME = dotenv.get("USER_DELETE_NAME");
  public static final String USER_DELETE_PHONE = dotenv.get("USER_DELETE_PHONE");


  // ADMIN
  public static final String ADMIN_EMAIL = dotenv.get("ADMIN_EMAIL");
  public static final String ADMIN_PASS = dotenv.get("ADMIN_PASS");
}
