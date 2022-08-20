package TestCases;

import ObjectRepository.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.testng.TestRunner.PriorityWeight.priority;
import static utility.TestData.*;
import static utility.driverSetUp.*;

public class HomePageTest {


     SignUpConfirmFect signUpConfirmFect;

    public WebDriver driver;
    HomePageFect homePageFect;
    CreateAccount createAccount;
    VerifyMobileNumber verifyMobileNumber;
    HomePageLogined homePageLogined;
    String verifyloginTitle;
    WebDriverWait wait;
    public boolean skipCondition = false;
    public CreateStory createStroy;
    private VerifySharedStoryPage verifySharedStoryPage;

    @Parameters({"url","browser"})
    @BeforeClass
    public void driveSetUp(String url,String browser) {

        if (browser.equalsIgnoreCase("chrome")){
            System.setProperty(EDGE_DRIVER, DRIVER_PATH);
            driver = new EdgeDriver();
        }
        else if(browser.equalsIgnoreCase("EDGE")){
            System.setProperty(EDGE_DRIVER, DRIVER_PATH);
            driver = new EdgeDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get(url);
        driver.manage().deleteAllCookies();

        Assert.assertEquals(driver.getTitle(),"Facebook – log in or sign up");

    }
    @Test
    public void Click_create_Account(){

        homePageFect = new HomePageFect(driver);
        homePageFect.createNewAccount();


    }
    @Test
    public void signUpPage(){

         createAccount = new CreateAccount(driver);
         Assert.assertEquals(createAccount.signPageVerify(),"Sign Up","Sign Page not found");
        System.out.println(createAccount.signPageVerify());

    }
    @Test(priority = 1)
    public void insertValueIntoField() throws InterruptedException {
        createAccount = new CreateAccount(driver);
        createAccount.enterFName();
        createAccount.enterLName();
        createAccount.enterMobileNumber();
        createAccount.enterPassword();
        createAccount.enterDa_Of_Birth();
        createAccount.enterGender();
        createAccount.clickOnSubmitButton();
         wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.titleIs("(1) Facebook"));
        verifyloginTitle =  driver.getTitle();
        System.out.println(verifyloginTitle);
        if(verifyloginTitle.equalsIgnoreCase("(1) Facebook")){

            System.out.println("Login page ");
            skipCondition = true;
        }

    }

    // @Test(priority = 2)
     public void signUpConfirmation(){

        signUpConfirmFect = new SignUpConfirmFect(driver);
        signUpConfirmFect.Click_continue_Button();

     }
//     @Test
//     public void

  @Test(priority = 3,enabled = true)
  public void addMobilePageVerify(){

        if(skipCondition){
            throw new SkipException("Skipping this exception");
        }
        verifyMobileNumber = new VerifyMobileNumber(driver);
      System.out.println(verifyMobileNumber.verifyAddNumber()+"  mobile page confirmation");
      Assert.assertTrue(verifyMobileNumber.verifyAddNumber().contains("mobile number"));

  }
  @Test(priority = 4)
  public void addMobileNumber(){

      if(skipCondition){
          throw new SkipException("Skipping this exception");
      }

        verifyMobileNumber.addMobileNum();

  }
  @Test(priority = 5)
  public void homePageVerify()
  {
      homePageLogined = new HomePageLogined(driver);
      String userName = homePageLogined.verifyHomePage();
      Assert.assertTrue(userName.contains(FName));
      homePageLogined.click_On_Create_Story();
      System.out.println("User Name from HomePage -->"+userName);
      wait = new WebDriverWait(driver,Duration.ofSeconds(10));
      wait.until(ExpectedConditions.titleIs("(1) Create stories | Facebook"));
      System.out.println("After waiting for title "+driver.getTitle());


  }
  @Test(priority = 6)
  public void create_story_page_verify(){

        createStroy = new CreateStory(driver);
        WebElement waitTillEle = createStroy.create_Text_Story();
        System.out.println("wait till preview --> "+waitTillEle.getText());
        wait = new WebDriverWait(driver,Duration.ofSeconds(15));
        wait.until(ExpectedConditions.textToBePresentInElement(waitTillEle,"Preview"));
        createStroy.insert_Text_Story( story);

      List<String> filterListOfFont = Arrays.asList(fontList);

        createStroy.select_font_Text_Story(filterListOfFont.get(1));
      createStroy.select_backgraund_Text_Story();
        createStroy.share_story();
        wait.until(ExpectedConditions.titleIs("(1) Facebook"));

  }
  @Test(priority = 7)
  public void verifySharedStory(){

      verifySharedStoryPage = new VerifySharedStoryPage(driver);
    String actual = verifySharedStoryPage.verify_after_story_shared();
    Assert.assertTrue(actual.equalsIgnoreCase("Welcome"),"Something Wrong please check in create story page");
      System.out.println(actual);


  }


    @AfterClass
    public void driverClose(){

        driver.quit();
}

}
