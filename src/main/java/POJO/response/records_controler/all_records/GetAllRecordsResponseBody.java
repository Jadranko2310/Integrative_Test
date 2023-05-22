package POJO.response.records_controler.all_records;

import POJO.response.user_controller.users_list.Content;
import POJO.response.user_controller.users_list.SortOut;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetAllRecordsResponseBody {
  private List<Content> content;
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
