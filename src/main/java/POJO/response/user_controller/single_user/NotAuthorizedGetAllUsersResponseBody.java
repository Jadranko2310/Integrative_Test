package POJO.response.user_controller.single_user;

import lombok.Getter;
import lombok.Setter;

/**
 * 'Not Authorized' response for GetSingleUser request deserialization model.
 */
@Getter
@Setter
public class NotAuthorizedGetAllUsersResponseBody {

  private String timestamp;
  private int status;
  private String error;
  private String message;
  private String path;

  public NotAuthorizedGetAllUsersResponseBody() {}

  public NotAuthorizedGetAllUsersResponseBody(
          String timestamp, int status, String error,
          String message, String path) {
    this.timestamp = timestamp;
    this.status = status;
    this.error = error;
    this.message = message;
    this.path = path;
  }
}
