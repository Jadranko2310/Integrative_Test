package setup.ui.base;

import lombok.Getter;
import lombok.Setter;
import setup.common.constants.FEConstants;

@Getter
@Setter
public class Url {

  public String logInPageUrl;
  public String usersHomePage;
  public String usersRecord;

  public Url() {
    this.logInPageUrl = FEConstants.LOG_IN_PAGE;
    this.usersHomePage = FEConstants.USERS_HOME_PAGE;
    this.usersRecord = FEConstants.USERS_RECORDS_PAGE;
  }
}
