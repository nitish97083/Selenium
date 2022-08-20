package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static utility.TestData.mNumber;
import static utility.TestData.mNumberForOTP;

public class VerifyMobileNumber {

    WebDriver driver;

    public VerifyMobileNumber(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "(//div[@class='osvssn79 kzdo7wvt cqf1kptm alzwoclg']// child::div)[1]/span")
    WebElement addMobileNumber;// wait condition

    @FindBy(xpath = "//input[@name = 'contactpoint']")
    WebElement insertMobileNumber;

    @FindBy(xpath = "//span[text()= 'Send Login Code']")
    WebElement otp;

    @FindBy(xpath = "//div[@class= 'm8h3af8h l7ghb35v kjdc1dyq kmwttqpk gh25dzvf']")
    WebElement waitTill;// get text and verify
    @FindBy(xpath = "(//div[@class='th51lws0 mfn553m3'])[1]")
    WebElement enterOtpPage;

    @FindBy(xpath = "(//span[text()='Next'])[2]")
    WebElement next;

   @FindBy(xpath = "(//span[text()='Update contact info'])[1]")
   WebElement modify;
public String  verifyAddNumber(){

    modify.click();
    return addMobileNumber.getText();


}
public void addMobileNum(){
    insertMobileNumber.click();
    insertMobileNumber.sendKeys(mNumberForOTP);
    System.out.println(otp.isDisplayed()+" Before waiting  "+otp.isEnabled());
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
     wait.until(ExpectedConditions.elementToBeClickable(otp));// wait till entering phone number
    System.out.println(otp.isDisplayed()+" after waiting   "+otp.isEnabled());
    otp.click(); // click on opt button
    wait.until(ExpectedConditions.visibilityOf(enterOtpPage));
    System.out.println("OTPPage Text"+enterOtpPage.getText());
    try {
        Thread.sleep(20000);
    } catch (InterruptedException e) {
        throw new RuntimeException(e);
    }
    wait.until(ExpectedConditions.elementToBeClickable(next));



}
}

