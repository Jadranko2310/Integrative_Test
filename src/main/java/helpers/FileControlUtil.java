package helpers;

import java.util.Properties;

/**
 * Enables reading values from properties.
 */
public class FileControlUtil {
  public Properties properties;

  public static final String FE_URL = "fe_routing.properties";

  public FileControlUtil(String file) throws Exception {
    properties = new Properties();
    properties.load(getClass().getResourceAsStream("/" + file));
  }

  public String getValue(String propertyKey) {
    return  properties.getProperty(propertyKey);
  }
}