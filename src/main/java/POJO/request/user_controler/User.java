package POJO.request.user_controler;

import lombok.Getter;
import lombok.Setter;
import setup.common.specification.Constants;

@Getter
@Setter
public class User {

  private String email;
  private String password;
  private String name;
  private String phone;

  public User(){}
  public User(String email, String password, String name, String phone) {
    this.email = email;
    this.password = password;
    this.name = name;
    this.phone = phone;
  }

  public User(UserType userType) {
    switch (userType) {
      case STANDARD -> {
        this.email = Constants.REGULAR_USER_EMAIL;
        this.password = Constants.REGULAR_USER_PASS;
        this.name = Constants.REGULAR_USER_NAME;
        this.phone = Constants.REGULAR_USER_PHONE;
      }
      case NON_VALID -> {
        this.email = Constants.INVALID_EMAIL;
        this.password = Constants.INVALID_PASS;
        this.name = Constants.INVALID_NAME;
        this.password = Constants.INVALID_NAME;
      }
    }
  }
}
