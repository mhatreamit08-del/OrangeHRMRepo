package DataProvider;

import Utils.ExcelUtils;
import org.testng.annotations.DataProvider;

public class UserData {

    @DataProvider(name="loginData")
    public Object[][] loginData()
    {
        return ExcelUtils.getData("src/test/resources/TestData/LoginUser.xlsx", "Login");

    }

@DataProvider(name="userData")
    public Object[][] userData()
    {
        return ExcelUtils.getData("src/test/resources/TestData/userData.xlsx", "Users");

    }
}
