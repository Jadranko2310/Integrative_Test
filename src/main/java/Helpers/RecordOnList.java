package Helpers;

import POJO.response.records_controler.all_records.Content;
import POJO.response.records_controler.all_records.GetAllRecordsResponseBody;
import io.restassured.response.Response;
import lombok.Getter;
import lombok.Setter;
import specification.api.request.GetAllRecordsRequest;

import java.util.List;

@Getter
@Setter
public class RecordOnList {

  GetAllRecordsRequest getAllRecordsRequest = new GetAllRecordsRequest();

  private String jobName;

  public String jobName (String jobNmb, String token) throws Exception {
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
