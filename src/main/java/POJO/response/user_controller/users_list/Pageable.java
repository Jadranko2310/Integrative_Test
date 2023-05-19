package POJO.response.user_controller.users_list;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pageable {
  private Sort sort;
  private int offset;
  private int pageNumber;
  private int pageSize;
  private boolean paged;
  private boolean unpaged;
}
