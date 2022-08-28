package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageLogined {


    WebDriver driver;
    @FindBy(xpath = "((//span[text()='Create story']//parent::span)[1]//parent::div//parent::div//parent::div)[1]")
    WebElement createStory;
    @FindBy(xpath = "(//div[@class='cgu29s5g'])[1]/ul//span[@class='b6ax4al1 lq84ybu9 hf30pyar om3e55n1']")
    WebElement homePageUserName;
    @FindBy(xpath = "(//div[@role='banner']//child::div)[24]")
    WebElement homeElementXpath;

//    @FindBy(xpath = "//div[@class='ekq1a7f9 myo4itp8 s8sjc6am on4d8346 z6erz7xo']/div")
//    WebElement createStory;

    public HomePageLogined(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);

    }

    public String verifyHomePage() {

        System.out.println(homePageUserName.getText() + "    jksdfkdsfgdf");
        return homePageUserName.getText();

    }
    public void click_On_home_icon() {

        homeElementXpath.click();


    }
        public void click_On_Create_Story() {

        System.out.println("create story 1 Text -->" + createStory.getText());

         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
         wait.until(ExpectedConditions.elementToBeClickable(createStory));
            System.out.println("create story Text -->" + createStory.getText());
            createStory.click();



    }

}
