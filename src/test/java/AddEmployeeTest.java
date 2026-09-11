import Base.BaseTest;
import Pages.*;
import Utils.ConfigReader;
import org.openqa.selenium.bidi.log.Log;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import DataProvider.UserData;


public class AddEmployeeTest extends BaseTest {
    Login login;
    Dashboard dashboard;


@Test(dataProvider = "userData",dataProviderClass = UserData.class)
    public void addEmployeeTest(String fName,String mName, String lName,String userName)
    {
        login=new Login();
        dashboard=new Dashboard();
        login.login(ConfigReader.getKey("username"),ConfigReader.getKey("password"));

        PIM_EmployeeList employeeList=dashboard.clickPIM();
        PIM_AddEmployee addEmployee=employeeList.clickAddEmployee();

        addEmployee.addEmpDetails(fName,mName,lName);
        addEmployee.clickCreateLogin();
        addEmployee.enterLoginDetails(userName);
        addEmployee.enterPassword("John@1234","John@1234");

        PIM_PersonalDetails personalDetails=addEmployee.saveEmployee();

        //now validation on personal details page

        Assert.assertEquals(personalDetails.getFirstName(),fName,"First name should be John12");
        Assert.assertEquals(personalDetails.getMiddleName(),mName, "First name should be F");
        Assert.assertEquals(personalDetails.getLastName(),lName, "Last name should be Doe");

        Assert.assertEquals(personalDetails.getEmpId(),addEmployee.getEmployeeID(),"Employee ID should Match");

        //Enter few other details
        personalDetails.selNationality("Indian");
        personalDetails.selMaritalStatus("Married");
        personalDetails.selGender("Male");
        personalDetails.enterDOB("1992-15-03");
        personalDetails.clickSave();

        Assert.assertTrue(personalDetails.getToastMessage().toLowerCase().contains("success"));






    }



}
