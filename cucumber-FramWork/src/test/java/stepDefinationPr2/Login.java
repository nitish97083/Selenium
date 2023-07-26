package stepDefinationPr2;

import StepDefinationT.CommonStepT;
import io.cucumber.java.en.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;

import utils.DriverUtil;


import java.io.File;
import java.io.IOException;

import static utiities.ConstantVariable.*;


public class Login {

   // WebDriver driver;
    CommonStepT commonStepT = new CommonStepT();
    @Given("Driver and system setup called")
    public void driverAndSystemSetupCalled() {

        driver = commonStepT.driver_and_system_setup();
    }
//    @Given("Navigate to Login page Url {string}")
//    public void navigate_to_login_page_url(String url) {
//
//        driver.get(url);
//    }
    @When("Enter the {string} and {string}")
    public void enter_the_and(String uId, String pWD) {

        driver.findElement(By.name("uid")).sendKeys(uId);
        driver.findElement(By.name("password")).sendKeys(pWD);
    }
    @Then("click on Login button")
    public void click_on_login_button() {

        driver.findElement(By.name("btnLogin")).click();
    }
    @Then("User should login successfully and driver close")
    public void user_should_login_successfully() throws IOException {

        try{

            Alert alert = driver.switchTo().alert();
            System.out.println(alert.getText());
            Assert.assertTrue(alert.getText().equalsIgnoreCase("User or Password is not valid"));
            alert.accept();
        }
        catch (NoAlertPresentException Ex){

            WebElement element = driver.findElement(By.xpath("//marquee[@class='heading3']"));
            DriverUtil.waitUntilVisibilityOfElement(driver,element);
            System.out.println(element.getText());
               TakesScreenshot screenshot = (TakesScreenshot) driver;


               File file = screenshot.getScreenshotAs(OutputType.FILE);
               File fileLocation =  new File("src.png");
            FileUtils.copyFile(file,fileLocation);
            Assert.assertTrue(element.getText().contains("Welcome To Manager's Page of Guru99"));
            System.out.println("Login Successfully!!!!!!!");

        }

       driver.quit();
    }

}

