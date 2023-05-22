package POJO.response.records_controler.all_records;

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
