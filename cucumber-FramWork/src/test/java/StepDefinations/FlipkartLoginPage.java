package StepDefinations;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static utiities.ConstantVariable.*;

public class FlipkartLoginPage {


    WebDriverWait wait ;
    @Given("Driver and system setup")
    public void driver_and_system_setup() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty(EDGE_DRIVER,DRIVER_PATH);
        System.out.println("Property set");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));


    }

    @And("Navigate to url {string}")
    public void navigate_to_url(String url) {
        driver.get(url);

    }

    @And("cancel login popup")
    public void cancel_login_Popup() {

        WebElement loginPop = driver.findElement(By.xpath("//span[text()='Login']/ancestor::div[@class='_2MlkI1']"));

        WebElement ele = driver.findElement(By.xpath("//img[@title='Flipkart']"));
        System.out.println(" Title "+ele.getText());

        if (loginPop.isDisplayed()) {

            driver.findElement(By.xpath(" //button[@class='_2KpZ6l _2doB4z']")).click();
        } else {
            System.out.println("No Pop Display");
        }
        System.out.println("Title after cancel  "+ele.getText());

    }

    @And("click on Login")
    public void click_on_login() throws InterruptedException {

        Thread.sleep(500);

       //  wait.until()
          driver.findElement(By.xpath("//a[@class = '_1_3w1N']")).click();

    }

    @When("User enter username {string} password {string}")
    public void user_enter_username_password(String username, String password) {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.xpath("//input[@class = '_2IX_2- VJZDxU']")).sendKeys(username);
        driver.findElement(By.xpath("//input[@type= 'password']")).sendKeys(password);


    }

    @And("Click on Submit")
    public void click_on_submit() {
        driver.findElement(By.xpath("//button[@class= '_2KpZ6l _2HKlqd _3AWRsL']")).click();

    }

    @Then("Login Page Displayed and verify User profile {string}")
    public void login_page_displayed_and_verify_user_profile(String expectedUserName) throws InterruptedException {
        /// wait = new WebDriverWait(driver,Duration.ofSeconds(5));

      // wait.until(ExpectedConditions.);
        Thread.sleep(1000);

        String actual = driver.findElement(By.xpath("(//div[@class= 'exehdJ'])[1]")).getText();
        System.out.println(expectedUserName +"    "  +actual);


    }
    @And("driver should be closed")
    public void driver_closed(){
        driver.close();
    }

}
