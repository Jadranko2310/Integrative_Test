package POJO.request.records_controler;

import Helpers.UserIDFromList;
import lombok.Getter;
import lombok.Setter;
import setup.common.constants.RecordConstants;
import setup.common.constants.UserConstants;
import setup.common.helpers.TokenGenerator;

@Getter
@Setter
public class Record {

  private int userId;
  private String jobNumber;
  private String jobName;
  private int paymentType;
  private String supplierName;
  private String purchaseDetail;
  private String totalPrice;
  private String credit;

  public Record(){};

  public Record(int userId, String jobNumber, String jobName,
                int paymentType, String supplierName, String purchaseDetail,
                String totalPrice, String credit) {
    this.userId = userId;
    this.jobNumber = jobNumber;
    this.jobName = jobName;
    this.paymentType = paymentType;
    this.supplierName = supplierName;
    this.purchaseDetail = purchaseDetail;
    this.totalPrice = totalPrice;
    this.credit = credit;
  }

  TokenGenerator token = new TokenGenerator(UserConstants.ADMIN_EMAIL, UserConstants.ADMIN_PASS);
  UserIDFromList userIDFromListsersId = new UserIDFromList();

  public Record(RecordsType recordsType) throws Exception {
    switch (recordsType) {
      case REGULAR -> {
        this.userId = userIDFromListsersId.find(UserConstants.RECORDS_USER_EMAIL, token.getToken());
        this.jobNumber = RecordConstants.REGULAR_RECORD_JOB_NMB;
        this.jobName = RecordConstants.REGULAR_RECORD_JOB_NAME;
        this.paymentType = RecordConstants.REGULAR_RECORD_PAYMENT_TYPE;
        this.supplierName = RecordConstants.REGULAR_RECORD_SUPLIER;
        this.purchaseDetail = RecordConstants.REGULAR_RECORD_PURCHASE_DETAIL;
        this.totalPrice = RecordConstants.REGULAR_RECORD_TOTAL_PRICE;
        this.credit = RecordConstants.REGULAR_RECORD_CREDIT;
      }
      case INVALID -> {
        this.userId = 0;
        this.jobNumber = RecordConstants.INVALID_RECORD_JOB_NMB;
        this.jobName = RecordConstants.INVALID_RECORD_JOB_NAME;
        this.paymentType = Integer.parseInt(RecordConstants.INVALID_RECORD_PAYMENT_TYPE);
        this.supplierName = RecordConstants.INVALID_RECORD_SUPLIER;
        this.purchaseDetail = RecordConstants.INVALID_RECORD_PURCHASE_DETAIL;
        this.totalPrice = RecordConstants.INVALID_RECORD_TOTAL_PRICE;
        this.credit = RecordConstants.INVALID_RECORD_CREDIT;
      }
    }
  }
}
