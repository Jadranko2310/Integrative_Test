package POJO.response.login;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

  private int id;
  private String email;
  private String name;
  private UserGroup userGroup;

}
