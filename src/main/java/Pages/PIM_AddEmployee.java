package Pages;

import Base.BasePage;
import Utils.WaitUtils;
import org.openqa.selenium.By;


public class PIM_AddEmployee extends BasePage {

    public PIM_AddEmployee()
    {
        super();
    }



    private final By firstName=By.name("firstName");
    private final By middleName=By.name("middleName");
    private final By lastName=By.name("lastName");
    private final By empIDText=By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input");
    private final By toggleButton=By.xpath("//span[ contains(@class,'switch-input')]");
    private final By usernameText=By.xpath("//label[text()='Username']/parent::div/following-sibling::div/input");
    private final By statusEnabled=By.xpath("//div[@class='oxd-radio-wrapper']/label[text()='Enabled']");
    private final By statusDisabled=By.xpath("//div[@class='oxd-radio-wrapper']/label[text()='Disabled']");
    private final By password=By.xpath("(//input[@type='password'])[1]");
    private final By confirmPassword=By.xpath("(//input[@type='password'])[2]");
    private final By submitButton=By.xpath("//button[@type='submit']");
    private final By cancelButton=By.xpath("//*[text()=' Cancel ']");



    public void addEmpDetails(String fName,String mName,String lName )
    {
        WaitUtils.visibilityOfElement(firstName).sendKeys(fName);
        WaitUtils.visibilityOfElement(middleName).sendKeys(mName);
        WaitUtils.visibilityOfElement(lastName).sendKeys(lName);

    }
    public String getEmployeeID()
    {
       return WaitUtils.presenceOfElementLocated(empIDText).getAttribute("value");
    }

    public void clickCreateLogin()
    {
        WaitUtils.visibilityOfElement(toggleButton).click();
    }
    public void enterLoginDetails(String username)
    {
        WaitUtils.visibilityOfElement(usernameText).sendKeys(username);
    }

    public void enterPassword(String pass,String confirmPass)
    {
        WaitUtils.visibilityOfElement(password).sendKeys(pass);
        WaitUtils.visibilityOfElement(confirmPassword).sendKeys(confirmPass);
    }

    public PIM_PersonalDetails saveEmployee()
    {
        WaitUtils.elementToBeClickable(submitButton).click();
        return new PIM_PersonalDetails();
    }


}
