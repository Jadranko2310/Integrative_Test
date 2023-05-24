package setup.common.constants;

import io.github.cdimascio.dotenv.Dotenv;

public class RecordConstants {

  static Dotenv dotenv = Dotenv.configure().load();

  // REGULAR ENTRY
  public static final String REGULAR_RECORD_JOB_NMB =
          dotenv.get("REGULAR_RECORD_JOB_NMB");
  public static final String REGULAR_RECORD_JOB_NAME =
          dotenv.get("REGULAR_RECORD_JOB_NAME");
  public static final int REGULAR_RECORD_PAYMENT_TYPE =
          Integer.parseInt(dotenv.get("REGULAR_RECORD_PAYMENT_TYPE"));
  public static final String REGULAR_RECORD_SUPLIER =
          dotenv.get("REGULAR_RECORD_SUPLIER");
  public static final String REGULAR_RECORD_PURCHASE_DETAIL =
          dotenv.get("REGULAR_RECORD_PURCHASE_DETAIL");
  public static final String REGULAR_RECORD_TOTAL_PRICE =
          dotenv.get("REGULAR_RECORD_TOTAL_PRICE");
  public static final String REGULAR_RECORD_CREDIT =
          dotenv.get("REGULAR_RECORD_CREDIT");

  // INVALID ENTRY
  public static final String INVALID_RECORD_JOB_NMB =
          dotenv.get("INVALID_RECORD_JOB_NMB=");
  public static final String INVALID_RECORD_JOB_NAME =
          dotenv.get("INVALID_RECORD_JOB_NAME");
  public static final String INVALID_RECORD_PAYMENT_TYPE =
          dotenv.get("INVALID_RECORD_PAYMENT_TYPE");
  public static final String INVALID_RECORD_SUPLIER =
          dotenv.get("INVALID_RECORD_SUPLIER");
  public static final String INVALID_RECORD_PURCHASE_DETAIL =
          dotenv.get("INVALID_RECORD_PURCHASE_DETAIL");
  public static final String INVALID_RECORD_TOTAL_PRICE =
          dotenv.get("INVALID_RECORD_TOTAL_PRICE");
  public static final String INVALID_RECORD_CREDIT =
          dotenv.get("INVALID_RECORD_CREDIT");

  // New Purchase Record for FE tests
  public static final String NEW_RECORD_JOB_NMB = dotenv.get("NEW_RECORD_JOB_NMB");
  public static final String NEW_RECORD_JOB_NAME = dotenv.get("NEW_RECORD_JOB_NAME");
  public static final String NEW_RECORD_PURCHASE_FROM =
          dotenv.get("NEW_RECORD_JOB_NAME");
  public static final String NEW_RECORD_PURCHASE_DETAIL=
          dotenv.get("NEW_RECORD_PURCHASE_DETAIL");
  public static final int NEW_RECORD_INVOICE_TOTAL =
          Integer.parseInt(dotenv.get("NEW_RECORD_INVOICE_TOTAL"));

  // New Purchase Record for FE tests (Admin Entry)
  public static final String A_NEW_RECORD_JOB_NMB = dotenv.get("A_NEW_RECORD_JOB_NMB");
  public static final String A_NEW_RECORD_JOB_NAME = dotenv.get("A_NEW_RECORD_JOB_NAME");
  public static final String A_NEW_RECORD_PURCHASE_FROM =
          dotenv.get("A_NEW_RECORD_PURCHASE_FROM");
  public static final String A_NEW_RECORD_PURCHASE_DETAIL=
          dotenv.get("A_NEW_RECORD_PURCHASE_DETAIL");
  public static final String A_NEW_RECORD_INVOICE_TOTAL =
          String.valueOf(Integer.parseInt(dotenv.get("A_NEW_RECORD_INVOICE_TOTAL")));
}
