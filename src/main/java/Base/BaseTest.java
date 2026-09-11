package Base;

import DriverFactory.DriverFactory;
import Utils.ConfigReader;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {


    @Parameters({"browser","env"})
    @BeforeMethod
    public void setUp(@Optional("") String browser,@Optional("") String env)
    {
        if (browser.trim().isEmpty())
        {
            browser= ConfigReader.getKey("browser");
        }
        DriverFactory.initDriver(browser);
        if(env.trim().isEmpty())
        {
            env=ConfigReader.getKey("base.url");
        }
        DriverFactory.getDriver().get(env);
    }

    @AfterMethod
    public void tearDown()
    {
        DriverFactory.quitDriver();
    }



}
