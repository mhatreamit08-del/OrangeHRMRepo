package Pages;

import Base.BasePage;
import Utils.WaitUtils;
import org.openqa.selenium.By;

public class PIM_EmployeeList extends BasePage {

    public PIM_EmployeeList()
    {
        super();
    }

    private final By addEmployee=By.xpath("//a[text()='Add Employee']");

    public PIM_AddEmployee clickAddEmployee()
    {
        WaitUtils.elementToBeClickable(addEmployee).click();
        return new PIM_AddEmployee();
    }


}
