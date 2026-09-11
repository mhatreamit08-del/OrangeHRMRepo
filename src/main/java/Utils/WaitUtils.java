package Utils;

import DriverFactory.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WaitUtils {

    private static final int timeout = Integer.parseInt(ConfigReader.getKey("time-out"));


    public static WebDriverWait getWait() {
        return new WebDriverWait(DriverFactory.getDriver(), Duration.ofSeconds(timeout));
    }

    //Visibility of Element located

    public static WebElement visibilityOfElement(By locator) {
        return getWait().until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //Invisibility of Element Located

    public static boolean invisibilityOfElementLocated(By locator) {
        return getWait().until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    //Element to be clickable
    public static WebElement elementToBeClickable(By locator) {
        return getWait().until(ExpectedConditions.elementToBeClickable(locator));
    }

    //Presence of Element

    public static WebElement presenceOfElementLocated(By locator) {
        return getWait().until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    //Alert is present
    public static Alert alertIsPresent()
    {
        return getWait().until(ExpectedConditions.alertIsPresent());
    }

    //Title is present

    public static boolean waitForTitleContains(String title)
    {
        return getWait().until(ExpectedConditions.titleContains(title));
    }

    //Wait and switch to iframe

    public static WebDriver waitAndSwitchToIframe(By locator)
    {
        return getWait().until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(locator));
    }

}
