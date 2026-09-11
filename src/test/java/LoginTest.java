import Base.BaseTest;
import Pages.Login;
import Utils.RetryAnalyser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import DataProvider.UserData;


public class LoginTest extends BaseTest {



@Test(dataProvider="loginData",retryAnalyzer = RetryAnalyser.class,dataProviderClass = UserData.class)
public void loginTest(String username,String password,String scenario)
{
    Login login=new Login();
    login.login(username,password);

    switch (scenario)
    {
        case "valid":
            Assert.assertTrue(login.getCurrentURL().contains("dashboard"),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index");
            break;

        case "invalid":
            Assert.assertEquals(login.getInvalidCredMsg(),"Invalid credentials","Expected invalid credentials message");
            break;

        case "blankUsername":
            Assert.assertEquals(login.getUsernameRequiredMessage(),"Required", "Required message is expected");
            break;

        case "blankPassword":
            Assert.assertEquals(login.getPasswordRequiredMessage(),"Required", "Required message is expected");
            break;


        case "blankBoth":
            Assert.assertEquals(login.getUsernameRequiredMessage(),"Required", "Required message is expected");
            Assert.assertEquals(login.getPasswordRequiredMessage(),"Required", "Required message is expected");
            break;
    }

}


}
