package data.handling;

/**
 * Creating users for test purposes.
 * Deleting all users after tests.
 */
public class UserDataHandler implements IDataHandler {

  @Override
  public void prepareData() {
    UserDataPrep userDataPrep = new UserDataPrep();
    userDataPrep.createUsersForTesting();
  }

  @Override
  public void cleanData() {
    UserDataCleanUp userDataCleanUp = new UserDataCleanUp();
    userDataCleanUp.cleanUpUserTestData();
  }
}