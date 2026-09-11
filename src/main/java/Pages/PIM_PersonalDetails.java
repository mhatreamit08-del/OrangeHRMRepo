package Pages;

import Base.BasePage;
import Utils.WaitUtils;
import org.openqa.selenium.By;

public class PIM_PersonalDetails extends BasePage {


    public PIM_PersonalDetails()
    {
        super();
    }

    private final By fNameText=By.name("firstName");
    private final By mNameText=By.name("middleName");
    private final By lNameText=By.name("lastName");
    private final By empIdText=By.xpath("//label[text()='Employee Id']/parent::div/following-sibling::div/input");
    private final By nationality=By.xpath("//label[text()='Nationality']/parent::div/following-sibling::div//div[text()='-- Select --']");
    private final By maritalStatus=By.xpath("//label[text()='Marital Status']/parent::div/following-sibling::div//div[text()='-- Select --']");
    private final By dobDate=By.xpath("//label[text()='Date of Birth']/parent::div/following-sibling::div//input");
    private final By genderMale=By.xpath("//label[text()='Male']");
    private final By genderFemale=By.xpath("//label[text()='Female']");
    private final By saveButton=By.xpath("(//button[@type='submit'])[1]");
    private final By toastMessage=By.xpath("//div[starts-with(@id,'oxd-toaster')]");


    public String getFirstName()
    {
     return WaitUtils.visibilityOfElement(fNameText).getAttribute("value");
    }

    public String getMiddleName()
    {
        return WaitUtils.visibilityOfElement(mNameText).getAttribute("value");
    }

    public String getLastName()
    {
        return WaitUtils.visibilityOfElement(lNameText).getAttribute("value");
    }

    public String getEmpId()
    {
        return WaitUtils.visibilityOfElement(empIdText).getAttribute("value");
    }

    public void selNationality(String nation)
    {
        WaitUtils.elementToBeClickable(nationality).click();

        // TEMPORARY - dump page source while dropdown is open, remove after inspecting
//        String pageSource = driver.getPageSource();
//        try {
//            assert pageSource != null;
//            java.nio.file.Files.write(
//                    java.nio.file.Paths.get("dropdown_debug.html"),
//                    pageSource.getBytes()
//            );
//        } catch (java.io.IOException e) {
//            e.printStackTrace();
//        }

        By option=By.xpath("//div[@role='option']//span[text()='" + nation + "']");
        WaitUtils.elementToBeClickable(option).click();

    }
    public void selMaritalStatus(String status)
    {
        WaitUtils.elementToBeClickable(maritalStatus).click();
        By option=By.xpath("//div[@role='option']//span[text()='" + status + "']");
        WaitUtils.elementToBeClickable(option).click();

    }

    public void enterDOB(String date)
    {
        WaitUtils.visibilityOfElement(dobDate).sendKeys(date);
    }
    public void selGender(String gender)
    {
        if(gender.equalsIgnoreCase("Male")) {
            WaitUtils.elementToBeClickable(genderMale).click();
        }
        else{
            WaitUtils.elementToBeClickable(genderFemale).click();

        }
    }


    public void clickSave()
    {
        WaitUtils.elementToBeClickable(saveButton).click();
    }

    public String getToastMessage()
    {
        return WaitUtils.visibilityOfElement(toastMessage).getText();
    }










}
