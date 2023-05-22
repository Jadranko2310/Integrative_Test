package data.handling;

import POJO.request.user_controler.User;
import POJO.request.user_controler.UserType;
import setup.common.constants.UserConstants;
import setup.common.helpers.TokenGenerator;
import specification.api.request.CreateUserRequest;

public class RecordsDataPrep {

  private final String token;
  TokenGenerator tokenGenerator = new TokenGenerator
          (UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);

  public RecordsDataPrep(String token) {
    this.token = tokenGenerator.getToken();
  }
  public void createDataForRecordsTesting() {
    CreateUserRequest createUser = new CreateUserRequest();
    User userForUpdate = new User(UserType.PREP_FOR_RECORDS);
    createUser.create(userForUpdate, token);
  }
}
