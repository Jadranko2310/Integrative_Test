package POJO.response.user_controller.login;

import lombok.Getter;
import lombok.Setter;

/**
 * Invalid response deserialization model.
 */
@Getter
@Setter
public class MissingCredentialsResponseBody {

  public String password;

  public String email;

  public MissingCredentialsResponseBody() {}

  public MissingCredentialsResponseBody Password(String password) {
    MissingCredentialsResponseBody pass = new MissingCredentialsResponseBody();
    this.password = password;
    return pass;
  }

  public MissingCredentialsResponseBody Email(String email) {
    MissingCredentialsResponseBody setEmail = new MissingCredentialsResponseBody();
    this.email = email;
    return setEmail;
  }

  public MissingCredentialsResponseBody(String password, String email) {
    this.password = password;
    this.email = email;
  }

  public MissingCredentialsResponseBody(String email) {
    this.email = email;
  }
}