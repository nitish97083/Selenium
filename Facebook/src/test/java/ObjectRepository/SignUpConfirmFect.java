package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignUpConfirmFect {
    WebDriver driver;
    @FindBy(xpath = "(//span[@class='b6ax4al1 lq84ybu9 hf30pyar om3e55n1 oshhggmv qm54mken'])[2]")
    WebElement continueButton;
    @FindBy(xpath = "//label[@class='rc-anchor-center-item rc-anchor-checkbox-label']")
    WebElement waitUntilElemVisible;
    // @FindBy(xpath = "(//span[@class='b6ax4al1 lq84ybu9 hf30pyar om3e55n1 oshhggmv qm54mken'])[2]")
    @FindBy(xpath = "(//div[@class='osvssn79 kzdo7wvt cqf1kptm alzwoclg']// child::div)[1]")
    WebElement addEmail;

    public SignUpConfirmFect(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void Click_continue_Button() {

        continueButton.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(waitUntilElemVisible));
        System.out.println("Continue Button disable and enable check Before captcha verify " + continueButton.isDisplayed() + " " + continueButton.isEnabled());
        System.out.println(waitUntilElemVisible.getText());
        waitUntilElemVisible.click();

        wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        System.out.println("Continue Button disable and enable check After Captcha verify" + continueButton.isDisplayed() + " " + continueButton.isEnabled());

        continueButton.click();
        wait.until(ExpectedConditions.visibilityOf(addEmail));
        System.out.println("  add Email page Text --> " + addEmail.getText());

    }

}

