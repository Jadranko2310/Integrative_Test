package data.handling;

import POJO.request.user_controller.User;
import POJO.request.user_controller.UserType;
import Helpers.TokenGenerator;
import setup.constants.UserConstants;
import specification.api.request.CreateUserRequest;

public class UserDataPrep {
  private final String token;

  public UserDataPrep() {this.token = tokenGenerator.getToken();}

  TokenGenerator tokenGenerator = new TokenGenerator
          (UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);

  public void createUsersForTesting() {
    CreateUserRequest createUser = new CreateUserRequest();
    User userForUpdate = new User(UserType.PRE_FOR_UPDATE);
    createUser.create(userForUpdate, token);
    User userForDelete = new User(UserType.PREP_FOR_DELETE);
    createUser.create(userForDelete, token);
  }
}
