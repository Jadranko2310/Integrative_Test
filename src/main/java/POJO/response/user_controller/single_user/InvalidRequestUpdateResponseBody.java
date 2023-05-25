package POJO.response.user_controller.single_user;

import lombok.Getter;
import lombok.Setter;

/**
 * 'Invalid request' response for GetSingleUser deserialization mode.
 */
@Getter
@Setter
public class InvalidRequestUpdateResponseBody {
  private String email;
  private String name;
  private String phone;

  public InvalidRequestUpdateResponseBody() {}

  public InvalidRequestUpdateResponseBody Email(String email) {
    InvalidRequestUpdateResponseBody emailBody =
            new InvalidRequestUpdateResponseBody();
    this.email = email;
    return emailBody;
  }

  public InvalidRequestUpdateResponseBody(String email, String name, String phone) {
    this.email = email;
    this.name = name;
    this.phone = phone;
  }
}
