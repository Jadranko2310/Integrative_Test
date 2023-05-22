package data.handling;

import POJO.request.records_controller.Record;
import POJO.request.records_controller.RecordsType;
import POJO.request.user_controller.User;
import POJO.request.user_controller.UserType;
import setup.common.constants.UserConstants;
import setup.common.helpers.TokenGenerator;
import specification.api.request.CreateRecordRequest;
import specification.api.request.CreateUserRequest;

public class RecordsDataPrep {

  private final String tokenAdmin;
  private final String tokenUser;

  TokenGenerator tokenGeneratorAdmin = new TokenGenerator
          (UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);
  TokenGenerator tokenGeneratorUser= new TokenGenerator
          (UserConstants.RECORDS_USER_EMAIL, UserConstants.REGULAR_USER_PASS);

  public RecordsDataPrep() {
    this.tokenAdmin = tokenGeneratorAdmin.getToken();
    this.tokenUser = tokenGeneratorUser.getToken();
  }

  CreateRecordRequest createRecordRequest = new CreateRecordRequest();

  public void createDataForRecordsTesting() {
    CreateUserRequest createUser = new CreateUserRequest();
    User recordsManager = new User(UserType.PREP_FOR_RECORDS);
    createUser.create(recordsManager, tokenAdmin);
  }

  public void createRecordsForTesting() throws Exception {
    Record record = new Record(RecordsType.REGULAR);
    createRecordRequest.create(record, tokenUser);
  }
}
