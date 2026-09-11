package Pages;

import Base.BasePage;
import Utils.WaitUtils;
import org.openqa.selenium.By;

public class Dashboard extends BasePage {

    public Dashboard()
    {
        super();
    }

    private final By pimLink=By.xpath("//span[text()='PIM']");

    public PIM_EmployeeList clickPIM()
    {
        WaitUtils.visibilityOfElement(pimLink).click();
        return new PIM_EmployeeList();
    }

}
