package POJO.response.user_controller.single_user;

import lombok.Getter;
import lombok.Setter;
import specification.api.request.CreateUserRequest;

@Getter
@Setter
public class CreateUserResponseBody {

  private int id;
  private String name;
  private String image;
  private String email;
  private String phone;

  public CreateUserResponseBody(){}

  public CreateUserResponseBody Email (String email) {
    CreateUserResponseBody emailResponse = new CreateUserResponseBody();
    this.email = email;
    return emailResponse;
  }

  public CreateUserResponseBody(int id, String name, String image, String email, String phone) {
    this.id = id;
    this.name = name;
    this.image = image;
    this.email = email;
    this.phone = phone;
  }
}
