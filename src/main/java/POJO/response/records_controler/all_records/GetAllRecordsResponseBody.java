package POJO.response.records_controler.all_records;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

/**
 * GetAllRecords request object.
 */
@Getter
@Setter
public class GetAllRecordsResponseBody {
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