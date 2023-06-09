package POJO.response.user_controller.single_user;

import lombok.Getter;
import lombok.Setter;

/**
 * Update User response deserialization model.
 */
@Getter
@Setter
public class UpdateUserResponseBody {
  private int id;
  private String name;
  private String image;
  private String email;
  private String phone;
}
