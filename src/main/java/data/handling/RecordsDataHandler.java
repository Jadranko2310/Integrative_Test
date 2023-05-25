package data.handling;

/**
 * Creating records and users that will manage records in tests.
 * Deleting all records and users.
 */
public class RecordsDataHandler implements IDataHandler {
  @Override
  public void prepareData() throws Exception {
    RecordsDataPrep recordsDataPrep = new RecordsDataPrep();
    recordsDataPrep.createUsersForRecordsManagement();
    recordsDataPrep.createRecordsForTesting();
  }

  @Override
  public void cleanData() {
    RecordsDataCleanup recordsDataCleanup = new RecordsDataCleanup();
    recordsDataCleanup.cleanUpRecordsTestData();
    UserDataCleanUp userDataCleanUp = new UserDataCleanUp();
    userDataCleanUp.cleanUpUserTestData();
  }
}