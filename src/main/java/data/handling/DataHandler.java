package data.handling;

public class DataHandler implements IDataHandler {

  @Override
  public void prepareTestData() {
    UserDataCleanUp adminActivityCleanup = new UserDataCleanUp();
    adminActivityCleanup.cleanUpTestData();
  }

  @Override
  public void cleanUpTestData() {

  }
}
