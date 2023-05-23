package Helpers;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;
import java.nio.file.Paths;

@Getter
@Setter
public class AbsolutePath {

  public String generateFromRelativePath(String relativeFilePath) {
    Path absoluteFilePath = Path.of(System.getProperty("user.dir") + "/" + relativeFilePath);
    return absoluteFilePath.toString();
  }
}
