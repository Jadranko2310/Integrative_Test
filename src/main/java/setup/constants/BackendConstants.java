package setup.constants;

import io.github.cdimascio.dotenv.Dotenv;

/**
 * Constants used in API test.
 */
public class BackendConstants {
  static Dotenv dotenv = Dotenv.configure().load();

  // ENDPOINTS BE
  public static final String BASE_URI = dotenv.get("BASE_URI");

  // Authorization controller endpoints
  public static final String LOG_IN = dotenv.get("LOGIN");

  // User controller endpoints
  public static final String ALL_USERS = dotenv.get("ALL_USERS");
  public static final String CREATE_USER = dotenv.get("CREATE_USER");
  public static final String DELETE_USER = dotenv.get("DELETE_USER");
  public static final String UPDATE_USER = dotenv.get("UPDATE_USER");

  // Records controller endpoints
  public static final String CREATE_RECORD = dotenv.get("CREATE_RECORD");
  public static final String GET_ALL_RECORDS_ADMIN = dotenv.get("GET_ALL_RECORDS_ADMIN");
  public static final String DELETE_RECORDS_ADMIN = dotenv.get("DELETE_RECORDS_ADMIN");
}