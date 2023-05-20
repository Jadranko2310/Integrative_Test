package data.handling;

public class DataHandler implements IDataHandler {

  @Override
  public void prepareData() {
    UserDataPrep userDataPrep = new UserDataPrep();
    userDataPrep.createUsersForTesting();
  }

  @Override
  public void cleanData() {
    UserDataCleanUp adminActivityCleanup = new UserDataCleanUp();
    adminActivityCleanup.cleanUpTestData();
  }
}
