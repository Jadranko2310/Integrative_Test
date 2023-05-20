package data.cleanup;

public class CleanUp {

  AdminActivityCleanup adminActivityCleanup = new AdminActivityCleanup();

  public static void cleanTestData() {
    AdminActivityCleanup adminActivityCleanup = new AdminActivityCleanup();
    adminActivityCleanup.cleanUpTestData();
  }
}
