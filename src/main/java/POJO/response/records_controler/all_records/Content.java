package POJO.response.records_controler.all_records;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class Content {
  private int id;
  private String jobName;
  private String jobNumber;
  private int paymentType;
  private String totalPrice;
  private String credit;
  private String supplierName;
  private String userName;
  private String poNumber;
  private int created;
  private String purchaseDetail;
  private int information;
  private List images;
}
