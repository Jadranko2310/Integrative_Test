package POJO.response.user_values;

import lombok.Getter;
import lombok.Setter;

/**
 * Can be used for get user values response deserialization.
 * As response will return JSON with list of bodies with no list name,
 * it needs to be deserialized as list.
 */
@Getter
@Setter
public class UserValuesList {
  private int id;
  private String name;
}
