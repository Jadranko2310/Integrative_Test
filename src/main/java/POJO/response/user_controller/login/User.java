package POJO.response.user_controller.login;

import lombok.Getter;
import lombok.Setter;
/**
 * User response deserialization model.
 */

@Getter
@Setter
public class User {

  private int id;
  private String email;
  private String name;
  private UserGroup userGroup;
}