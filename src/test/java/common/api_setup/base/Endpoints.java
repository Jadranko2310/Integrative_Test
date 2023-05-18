package common.api_setup.base;

import base.config.FileControlUtil;

public class Endpoints {

  public static final FileControlUtil fileControlEndpoints;

  static {
    try {
      fileControlEndpoints = new FileControlUtil(FileControlUtil.ENDPOINTS);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  // ENDPOINTS
  public static final String BASE_URI = fileControlEndpoints.getValue("BASE_URI");
}
