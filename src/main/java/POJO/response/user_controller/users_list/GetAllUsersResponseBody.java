package POJO.response.user_controller.users_list;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllUsersResponseBody {
  private List<Content> content;
  private Pageable pageable;
  private int totalPages;
  private int totalElements;
  private boolean last;
  private int size;
  private int number;
  private SortOut sort;
  private boolean first;
  private int numberOfElements;
  private boolean empty;
}
