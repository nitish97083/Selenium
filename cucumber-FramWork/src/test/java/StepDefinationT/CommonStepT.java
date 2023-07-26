package StepDefinationT;

import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.time.Duration;

import static utiities.ConstantVariable.*;
import static utiities.ConstantVariable.driver;

public class CommonStepT {

    @Given("Driver and system setup")
    public WebDriver driver_and_system_setup() {
        // Write code here that turns the phrase above into concrete actions
        System.setProperty(EDGE_DRIVER,DRIVER_PATH);
        System.out.println("Property set");
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        return driver;
    }


    @Given("Navigate to Login page Url {string}")
    public void navigate_to_login_page_url(String url) {

        driver.get(url);
    }
}
