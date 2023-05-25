package data.handling;

import helpers.TokenGenerator;
import POJO.request.records_controller.Record;
import POJO.request.records_controller.RecordsType;
import POJO.request.user_controller.User;
import POJO.request.user_controller.UserType;
import setup.constants.UserConstants;
import specification.api.request.CreateRecordRequest;
import specification.api.request.CreateUserRequest;

/**
 * Creating records and users that will manage records.
 */
public class RecordsDataPrep {

  private final String tokenAdmin;
  private final String tokenUser;

  public RecordsDataPrep() {
    this.tokenAdmin = tokenGeneratorAdmin.getToken();
    this.tokenUser = tokenGeneratorUser.getToken();
  }

  TokenGenerator tokenGeneratorAdmin = new TokenGenerator(
          UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);

  TokenGenerator tokenGeneratorUser = new TokenGenerator(
          UserConstants.RECORDS_USER_EMAIL, UserConstants.RECORDS_USER_PASS);

  /**
   * Creating one predefined user.
   */
  public void createUsersForRecordsManagement() {
    CreateUserRequest createUser = new CreateUserRequest();
    User recordsManager = new User(UserType.PREP_FOR_RECORDS);
    createUser.create(recordsManager, tokenGeneratorAdmin.getToken());
  }

  /**
   * Creating records needed for testing.
   */
  public void createRecordsForTesting() throws Exception {
    CreateRecordRequest createRecordRequest = new CreateRecordRequest();
    Record record = new Record(RecordsType.REGULAR, tokenAdmin);
    createRecordRequest.create(record, tokenUser);
  }
}