package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static utility.TestData.*;

public class CreateAccount {
    WebDriver driver ;
    public CreateAccount(WebDriver driver){

        this.driver = driver;
        PageFactory.initElements(driver,this);


    }
    @FindBy(xpath = "//div[text()='Sign Up']")
    WebElement signUpPageAttribute;

    @FindBy(xpath = "//input[@name ='firstname']")
    WebElement firstName;

    @FindBy(xpath = "//input[@name ='lastname']")
    WebElement surName;

    @FindBy(xpath = "//input[@name ='reg_passwd__']")
    WebElement passWord;

    @FindBy(xpath = "//input[@name ='reg_email__']")
    WebElement mobileNumber;
     @FindBy(id = "day")
     WebElement selectDate;

     @FindBy(id ="month")
     WebElement selectMonth;

     @FindBy(id = "year")
     WebElement selYear;

     @FindBy(xpath = "//span[@class='_5k_3']//span")
     List<WebElement> gender;

     @FindBy(xpath = "//button[@name ='websubmit']")
     WebElement submit;
     @FindBy(xpath = "(//span[@class='b6ax4al1 lq84ybu9 hf30pyar om3e55n1 oshhggmv qm54mken'])[1]")
     WebElement waitUntill;

    public String  signPageVerify(){

       return signUpPageAttribute.getText();

    }
    public void enterFName () throws InterruptedException {

        firstName.sendKeys(FName);
    }
    public void enterLName () throws InterruptedException {

        surName.sendKeys(lName);
    }
    public void enterMobileNumber () throws InterruptedException {

        mobileNumber.sendKeys(mNumber);
    }
    public void enterPassword () throws InterruptedException {

        passWord.sendKeys(password);
    }
    public void enterDa_Of_Birth () throws InterruptedException {

        insertDOB();
    }
    public void enterGender () throws InterruptedException {

        selectGender();
    }

    public void clickOnSubmitButton () throws InterruptedException {

        submit.click();
    }




    public void insertDOB(){

        Select selectDay = new Select(selectDate);
        selectDay.selectByVisibleText("10");
        Select selectMon = new Select(selectMonth);
        selectMon.selectByIndex(5);
        Select selectYear = new Select(selYear);
        selectYear.selectByVisibleText("2003");

    }
    public void selectGender(){

        System.out.println(gender.size());
        gender.stream().filter(s->s.getText().equalsIgnoreCase("Male")).forEach(s->
                {
                    System.out.println(s.getText());
                    s.click();
                }
                );

    }
}

