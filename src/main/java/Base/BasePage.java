package Base;

import DriverFactory.DriverFactory;
import org.openqa.selenium.WebDriver;

public class BasePage {

    protected WebDriver driver;

    public BasePage()
    {
        this.driver= DriverFactory.getDriver();
    }

    public String getPageTitle()
    {
        return driver.getTitle();
    }

    public String getCurrentURL()
    {
        return driver.getCurrentUrl();
    }




}
