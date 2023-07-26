package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class DriverUtil {

    static Duration EXPLICIT_WAIT_TIME = Duration.ofSeconds(5);

    public static void waitUntilVisibilityOfElement(WebDriver driver, WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public static void waitAlertIsPresent(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, EXPLICIT_WAIT_TIME);
        wait.until(ExpectedConditions.alertIsPresent());

    }


}
