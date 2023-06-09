package POJO.request.user_controller;

import lombok.Getter;
import lombok.Setter;
import setup.constants.UserConstants;

/**
 * User model.
 */
@Getter
@Setter
public class User {

  private String email;
  private String password;
  private String name;
  private String phone;

  public User() {}

  public User(String email, String password, String name, String phone) {
    this.email = email;
    this.password = password;
    this.name = name;
    this.phone = phone;
  }

  public User(UserType userType) {
    switch (userType) {
      case STANDARD -> {
        this.email = UserConstants.REGULAR_USER_EMAIL;
        this.password = UserConstants.REGULAR_USER_PASS;
        this.name = UserConstants.REGULAR_USER_NAME;
        this.phone = UserConstants.REGULAR_USER_PHONE;
      }
      case NON_VALID -> {
        this.email = UserConstants.INVALID_EMAIL;
        this.password = UserConstants.INVALID_PASS;
        this.name = UserConstants.INVALID_NAME;
        this.password = UserConstants.INVALID_NAME;
      }
      case PRE_FOR_UPDATE -> {
        this.email = UserConstants.USER_UPDATE_EMAIL;
        this.password = UserConstants.USER_UPDATE_PASS;
        this.name = UserConstants.USER_UPDATE_NAME;
        this.phone = UserConstants.USER_UPDATE_PHONE;
      }
      case PREP_FOR_DELETE -> {
        this.email = UserConstants.USER_DELETE_EMAIL;
        this.password = UserConstants.USER_DELETE_PASS;
        this.name = UserConstants.USER_DELETE_NAME;
        this.phone = UserConstants.USER_DELETE_EMAIL;
      }
      case PREP_FOR_RECORDS -> {
        this.email = UserConstants.RECORDS_USER_EMAIL;
        this.password = UserConstants.RECORDS_USER_PASS;
        this.name = UserConstants.RECORDS_USER_NAME;
        this.phone = UserConstants.RECORDS_USER_PHONE;
      }
      case FE_CREATE_USER -> {
        this.email = UserConstants.FE_USER_EMAIL;
        this.password = UserConstants.FE_USER_PASS;
        this.name = UserConstants.FE_USER_NAME;
        this.phone = UserConstants.FE_USER_PHONE;
      }
      default -> throw new RuntimeException("The user type invalid, please check"
              + "user type object and user type");
    }
  }
}
