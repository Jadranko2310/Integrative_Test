package POJO.frontend;

import lombok.Getter;
import lombok.Setter;
import org.bouncycastle.est.CACertsResponse;
import setup.common.constants.RecordConstants;

@Getter
@Setter
public class NewRecord {
  private String jobNmb;
  private String jobName;
  private String purchaseFrom;
  private String purchaseDetail;
  private String invoiceTotal;

  public NewRecord(){}

  public NewRecord(String jobNmb, String jobName, String purchaseFrom,
                   String purchaseDetail, String invoiceTotal) {
    this.jobNmb = jobNmb;
    this.jobName = jobName;
    this.purchaseFrom = purchaseFrom;
    this.purchaseDetail = purchaseDetail;
    this.invoiceTotal = invoiceTotal;
  }

  public NewRecord(RecordType type) {
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
        this.invoiceTotal = RecordConstants.REGULAR_RECORD_TOTAL_PRICE;
      }
      case ADMIN_ENTRY -> {
        this.jobNmb = RecordConstants.A_NEW_RECORD_JOB_NMB;
        this.jobName = RecordConstants.A_NEW_RECORD_JOB_NAME;
        this.purchaseFrom = RecordConstants.A_NEW_RECORD_PURCHASE_FROM;
        this.purchaseDetail = RecordConstants.A_NEW_RECORD_PURCHASE_DETAIL;
        this.invoiceTotal = RecordConstants.A_NEW_RECORD_INVOICE_TOTAL;
      }
      case INVALID_RECORD -> {
        this.jobNmb = RecordConstants.INVALID_RECORD_JOB_NMB;
        this.jobName = RecordConstants.INVALID_RECORD_JOB_NAME;
        this.purchaseFrom = RecordConstants.A_NEW_RECORD_PURCHASE_FROM;
        this.purchaseDetail = RecordConstants.INVALID_RECORD_PURCHASE_DETAIL;
        this.invoiceTotal = RecordConstants.INVALID_RECORD_TOTAL_PRICE;
      }
    }
  }
}
