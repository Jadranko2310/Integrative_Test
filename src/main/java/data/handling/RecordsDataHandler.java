package data.handling;

public class RecordsDataHandler implements IDataHandler{
  @Override
  public void prepareData() throws Exception {
    RecordsDataPrep recordsDataPrep = new RecordsDataPrep();
    recordsDataPrep.createUserForRecordsManagement();
    recordsDataPrep.createRecordsForTesting();
  }

  @Override
  public void cleanData() {
    RecordsDataCleanup recordsDataCleanup = new RecordsDataCleanup();
    recordsDataCleanup.cleanUpTestData();

  }
}
