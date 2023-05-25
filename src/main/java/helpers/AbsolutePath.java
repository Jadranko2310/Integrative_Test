package helpers;

import java.nio.file.Path;
import lombok.Getter;
import lombok.Setter;

/**
 * Will generate absolute path for file on local machine. It will generate path to
 * project on local machine and add relative path from parameter.
 */
@Getter
@Setter
public class AbsolutePath {

  public String generateFromRelativePath(String relativeFilePath) {
    Path absoluteFilePath = Path.of(System.getProperty("user.dir") + "/" + relativeFilePath);
    return absoluteFilePath.toString();
  }
}