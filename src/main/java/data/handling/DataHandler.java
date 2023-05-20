package data.handling;

public class DataHandler implements IDataHandler {

  @Override
  public void prepareData() {
  }

  @Override
  public void cleanData() {
    UserDataCleanUp adminActivityCleanup = new UserDataCleanUp();
    adminActivityCleanup.cleanUpTestData();
  }
}
