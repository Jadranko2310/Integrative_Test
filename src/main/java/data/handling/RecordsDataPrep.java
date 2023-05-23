package data.handling;

import POJO.request.records_controller.Record;
import POJO.request.records_controller.RecordsType;
import POJO.request.user_controller.User;
import POJO.request.user_controller.UserType;
import org.testng.annotations.Test;
import setup.common.constants.UserConstants;
import setup.common.helpers.TokenGenerator;
import specification.api.request.CreateRecordRequest;
import specification.api.request.CreateUserRequest;

public class RecordsDataPrep {

  private final String tokenAdmin;

  public RecordsDataPrep(){
    this.tokenAdmin = tokenGeneratorAdmin.getToken();
  }

  TokenGenerator tokenGeneratorAdmin = new TokenGenerator
          (UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);


  public void createUserForRecordsManagement() {
    CreateUserRequest createUser = new CreateUserRequest();
    User recordsManager = new User(UserType.PREP_FOR_RECORDS);
    createUser.create(recordsManager, tokenGeneratorAdmin.getToken());
  }

  public void createRecordsForTesting() throws Exception {
    CreateRecordRequest createRecordRequest = new CreateRecordRequest();
    Record record = new Record(RecordsType.REGULAR, tokenAdmin);
    TokenGenerator tokenGeneratorUser= new TokenGenerator
            (UserConstants.RECORDS_USER_EMAIL, UserConstants.RECORDS_USER_PASS);
    String tokenUser = tokenGeneratorUser.getToken();
    createRecordRequest.create(record, tokenUser);
  }
}
