package helpers;

import POJO.response.records_controler.all_records.Content;
import POJO.response.records_controler.all_records.GetAllRecordsResponseBody;
import io.restassured.response.Response;
import java.util.List;
import lombok.Getter;
import lombok.Setter;
import specification.api.request.GetAllRecordsRequest;

/**
 * Finding record on list of records.
 */
@Getter
@Setter
public class RecordOnList {

  GetAllRecordsRequest getAllRecordsRequest = new GetAllRecordsRequest();

  private String jobName;

  /**
   * Finding record attribute 'Job Name' for record on records list based on
   * parameter 'Job Number'
   */
  public String jobName(String jobNmb, String token) {
    Response response = getAllRecordsRequest.list(token);
    GetAllRecordsResponseBody responseBody =
            response.as(GetAllRecordsResponseBody.class);
    List<Content> contentList = responseBody.getContent();
    for (Content content : contentList) {
      if (content.getJobNumber().equals(jobNmb)) {
        setJobName(content.getJobName());
      }
    }
    return jobName;
  }
}
