package setup.common.specification;

import io.github.cdimascio.dotenv.Dotenv;
import org.checkerframework.checker.signature.qual.IdentifierOrPrimitiveType;
import setup.common.helpers.FileControlUtil;

public class Constants {

  public static final FileControlUtil fileControlEndpoints;


  static {
    try {
      fileControlEndpoints = new FileControlUtil(FileControlUtil.ENDPOINTS);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  static Dotenv dotenv = Dotenv.configure().load();

  // ENDPOINTS

  // BASE URI
  public static final String BASE_URI = fileControlEndpoints.getValue("BASE_URI");

  public static final String LOG_IN = fileControlEndpoints.getValue("LOGIN");


  // USER CREDENTIALS

  // ADMIN

  public static final String ADMIN_EMAIL = dotenv.get("ADMIN_EMAIL");
  public static final String ADMIN_PASS = dotenv.get("ADMIN_PASS");
}
