package Pages;

import Base.BasePage;
import Utils.WaitUtils;
import org.openqa.selenium.By;

public class Login extends BasePage {

    //below constructor can be skipped or removed as it is no arg constructor
    // and java will call it implicitly even if we remove it unless we want to have some implementation.

    public Login()
    {
        super();
    }

    //WebElements:

    private final By username=By.name("username");
    private final By password=By.name("password");
    private final By loginButton=By.xpath("//button[@type='submit']");
    private final By usernameRequiredMsg=By.xpath("//input[@name='username']/parent::div/following-sibling::span");
    private final By passwordRequiredMsg=By.xpath("//input[@name='password']/parent::div/following-sibling::span");
    private final By invalidCredMsg=By.xpath("//p[contains(@class,'oxd-alert-content-text')]");


    //Methods

    public void enterUsername(String user)
    {
        WaitUtils.visibilityOfElement(username).sendKeys(user);
    }

    public void enterPass(String pass)
    {
        WaitUtils.visibilityOfElement(password).sendKeys(pass);

    }

    public void clickLogin()
    {
        WaitUtils.elementToBeClickable(loginButton).click();
    }

    public void login(String user, String pass)
    {
       enterUsername(user);
       enterPass(pass);
       clickLogin();
    }

    //Required field validation message

    public String getUsernameRequiredMessage()
    {
        return WaitUtils.visibilityOfElement(usernameRequiredMsg).getText();
    }

    public String getPasswordRequiredMessage()
    {
       return WaitUtils.visibilityOfElement(passwordRequiredMsg).getText();
    }

    //Invalid/Wrong creds message

    public String getInvalidCredMsg()
    {
        return WaitUtils.visibilityOfElement(invalidCredMsg).getText();
    }


}
