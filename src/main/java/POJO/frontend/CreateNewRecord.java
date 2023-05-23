package POJO.frontend;

import lombok.Getter;
import lombok.Setter;
import setup.common.constants.RecordConstants;

@Getter
@Setter
public class CreateNewRecord {
  private String jobNmb;
  private String jobName;
  private String purchaseFrom;
  private String purchaseDetail;
  private int invoiceTotal;

  public CreateNewRecord(){}

  public CreateNewRecord(String jobNmb, String jobName, String purchaseFrom,
                         String purchaseDetail, int invoiceTotal) {
    this.jobNmb = jobNmb;
    this.jobName = jobName;
    this.purchaseFrom = purchaseFrom;
    this.purchaseDetail = purchaseDetail;
    this.invoiceTotal = invoiceTotal;
  }

  public CreateNewRecord(RecordType type) {
    switch (type) {
      case NEW_RECORD -> {
        this.jobNmb = RecordConstants.NEW_RECORD_JOB_NMB;
        this.jobName = RecordConstants.NEW_RECORD_JOB_NAME;
        this.purchaseFrom = RecordConstants.NEW_RECORD_PURCHASE_FROM;
        this.purchaseDetail = RecordConstants.NEW_RECORD_PURCHASE_DETAIL;
        this.invoiceTotal = RecordConstants.NEW_RECORD_INVOICE_TOTAL;
      }
      case EXISTING_RECORD -> {
        this.jobNmb = RecordConstants.REGULAR_RECORD_JOB_NMB;
        this.jobName = RecordConstants.REGULAR_RECORD_JOB_NAME;
        this.purchaseFrom = RecordConstants.NEW_RECORD_PURCHASE_FROM;
        this.purchaseDetail = RecordConstants.NEW_RECORD_PURCHASE_DETAIL;
        this.invoiceTotal = Integer.parseInt(RecordConstants.REGULAR_RECORD_TOTAL_PRICE);
      }
    }
  }
}
