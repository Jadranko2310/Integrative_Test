package data.handling;

import helpers.TokenGenerator;
import POJO.response.records_controler.all_records.Content;
import POJO.response.records_controler.all_records.GetAllRecordsResponseBody;
import io.restassured.response.Response;
import java.util.List;
import setup.constants.UserConstants;
import specification.api.request.DeleteRecordRequest;
import specification.api.request.GetAllRecordsRequest;

/**
 * Deleting all records.
 */
public class RecordsDataCleanup {

  private final String tokenAdmin;

  public RecordsDataCleanup() {
    this.tokenAdmin = tokenGenerator.getToken();
  }

  TokenGenerator tokenGenerator = new TokenGenerator(
          UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);

  GetAllRecordsRequest getAllRecordsRequest = new GetAllRecordsRequest();

  DeleteRecordRequest deleteRecordRequest = new DeleteRecordRequest();

  public GetAllRecordsResponseBody getRecordsList() {
    Response response = getAllRecordsRequest.list(tokenAdmin);
    return response.as(GetAllRecordsResponseBody.class);
  }

  /**
   * Going through list of deserialized objects 'Content' take records id,
   * and use it for deleting records.
   */
  public void cleanUpRecordsTestData() {
    List<Content> contentList = getRecordsList().getContent();
    if (contentList.isEmpty()) {
      return;
    }
    for (Content content : contentList) {
      deleteRecordRequest.delete(content.getId(), tokenAdmin);
    }
  }
}