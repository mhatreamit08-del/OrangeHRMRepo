package DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import java.util.HashMap;
import java.util.Map;

public class DriverFactory {

    private static final ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();



    public static void initDriver(String browser)
    {
        WebDriver driver;

        switch (browser.toLowerCase())
        {
            case "chrome":
                ChromeOptions chromeOptions=new ChromeOptions();

                Map<String, Object> prefs = new HashMap<>();
                prefs.put("profile.password_manager_leak_detection", false);
                prefs.put("credentials_enable_service", false);
                prefs.put("profile.password_manager_enabled", false);
                chromeOptions.setExperimentalOption("prefs", prefs);
                chromeOptions.addArguments("--disable-infobars");
                //chromeOptions.addArguments("--headless=new");


                driver=new ChromeDriver(chromeOptions);
                break;

            case "edge":
                EdgeOptions edgeOptions=new EdgeOptions();

                Map<String, Object> edgeprefs = new HashMap<>();
                edgeprefs.put("profile.password_manager_leak_detection", false);
                edgeprefs.put("credentials_enable_service", false);
                edgeprefs.put("profile.password_manager_enabled", false);
                edgeOptions.setExperimentalOption("prefs", edgeprefs);
                edgeOptions.addArguments("--disable-infobars");

                driver=new EdgeDriver(edgeOptions);
                break;

            default:
                throw new IllegalArgumentException("Unsupported Browser: " +browser);




        }
        driver.manage().window().maximize();
        tlDriver.set(driver);

    }


    public static WebDriver getDriver()
    {
        return tlDriver.get();
    }

    public static void quitDriver()
    {
        if(getDriver()!=null)
        {
            getDriver().quit();
            tlDriver.remove();
        }
    }








}
