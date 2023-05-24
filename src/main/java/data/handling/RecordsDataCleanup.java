package data.handling;

import POJO.response.records_controler.all_records.Content;
import POJO.response.records_controler.all_records.GetAllRecordsResponseBody;
import io.restassured.response.Response;
import setup.constants.UserConstants;
import Helpers.TokenGenerator;
import specification.api.request.DeleteRecordRequest;
import specification.api.request.GetAllRecordsRequest;

import java.util.List;

public class RecordsDataCleanup {

  private final String token;

  public RecordsDataCleanup() {
    this.token = tokenGenerator.getToken();
  }

  TokenGenerator tokenGenerator = new TokenGenerator
          (UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);

  GetAllRecordsRequest getAllRecordsRequest = new GetAllRecordsRequest();

  DeleteRecordRequest deleteRecordRequest = new DeleteRecordRequest();

  public GetAllRecordsResponseBody getRecordsList() {
    Response response = getAllRecordsRequest.list(token);
    return response.as(GetAllRecordsResponseBody.class);
  }

  public void cleanUpRecordsTestData() {
    List<Content> contentList = getRecordsList().getContent();
    if (contentList.isEmpty()) {
      return;
    }
    for (Content content: contentList) {
      deleteRecordRequest.delete(content.getId(), token);
    }
  }
}
