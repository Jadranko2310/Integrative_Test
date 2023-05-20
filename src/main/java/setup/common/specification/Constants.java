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


  // USER CREDENTIALS

  // ADMIN
  public static final String ADMIN_EMAIL = dotenv.get("ADMIN_EMAIL");
  public static final String ADMIN_PASS = dotenv.get("ADMIN_PASS");
}
