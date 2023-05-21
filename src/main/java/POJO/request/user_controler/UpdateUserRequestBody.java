package POJO.request.user_controler;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateUserRequestBody {
  public String email;
  public String name;
  public String phone;
}
