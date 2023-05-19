package api;

import POJO.response.login.LogInResponseBody;
import POJO.response.user_values.UserValuesList;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.restassured.common.mapper.TypeRef;
import org.testng.Assert;
import org.testng.annotations.Test;
import setup.api.BaseAPITest;
import setup.common.helpers.TokenGenerator;
import setup.common.specification.Constants;
import specification.api.request.GetUserValues;
import specification.api.request.LogIn;

import java.util.List;

public class AdminFunctionalTest extends BaseAPITest {

  TokenGenerator token = new TokenGenerator(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
  LogIn logIn = new LogIn();
  GetUserValues getUserValues = new GetUserValues();


  @Test
  public void adminLogIn() {
    response = logIn.request(Constants.ADMIN_EMAIL, Constants.ADMIN_PASS);
    LogInResponseBody responseBody = response.getBody().as(LogInResponseBody.class);

    softAssert.assertEquals(response.statusCode(), 200);
    softAssert.assertEquals(responseBody.getUser().getUserGroup().getId(), 1);
  }

  @Test
  public void getUsersValues() {
    response = getUserValues
            .getListOfUsersBaseValues(token.getToken());
    List<UserValuesList> userValuesLists = response.as(new TypeRef<>() {});

    Assert.assertEquals(response.statusCode(), 200);
    Assert.assertEquals(userValuesLists.get(0).getId(), 8);
  }
}
