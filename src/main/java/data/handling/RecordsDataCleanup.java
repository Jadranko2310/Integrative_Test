package data.handling;

import setup.common.constants.UserConstants;
import setup.common.helpers.TokenGenerator;
import specification.api.request.DeleteRecordRequest;
import specification.api.request.GetAllRecordsRequest;

public class RecordsDataCleanup {

  private final String token;

  public RecordsDataCleanup() {
    this.token = tokenGenerator.getToken();
  }

  TokenGenerator tokenGenerator = new TokenGenerator
          (UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);

  GetAllRecordsRequest getAllRecordsRequest = new GetAllRecordsRequest();

  DeleteRecordRequest deleteRecordRequest = new DeleteRecordRequest();
}
