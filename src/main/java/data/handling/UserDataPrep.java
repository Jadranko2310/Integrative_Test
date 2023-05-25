package data.handling;

import helpers.TokenGenerator;
import POJO.request.user_controller.User;
import POJO.request.user_controller.UserType;
import setup.constants.UserConstants;
import specification.api.request.CreateUserRequest;

/**
 * Creating users needed for testing.
 */
public class UserDataPrep {
  private final String token;

  public UserDataPrep() {
    this.token = tokenGenerator.getToken();
  }

  TokenGenerator tokenGenerator = new TokenGenerator(
          UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);

  /**
   * Creating users method.
   */
  public void createUsersForTesting() {
    CreateUserRequest userRequest = new CreateUserRequest();
    User userForUpdate = new User(UserType.PRE_FOR_UPDATE);
    userRequest.create(userForUpdate, token);
    User userForDelete = new User(UserType.PREP_FOR_DELETE);
    userRequest.create(userForDelete, token);
  }
}