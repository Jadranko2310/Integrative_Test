package POJO.response.user_controller.login;

import lombok.Getter;
import lombok.Setter;

/**
 * User Group response deserialization model.
 */
@Getter
@Setter
public class UserGroup {

  private int id;
  private String key;
  private String name;
}