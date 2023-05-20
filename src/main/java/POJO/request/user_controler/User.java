package POJO.request.user_controler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

  private String email;
  private String password;
  private String name;
  private String phone;

  public User(String email, String password, String name, String phone) {
    this.email = email;
    this.password = password;
    this.name = name;
    this.phone = phone;
  }
}
