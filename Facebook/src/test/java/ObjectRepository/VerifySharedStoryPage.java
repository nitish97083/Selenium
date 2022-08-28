package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class VerifySharedStoryPage {

    WebDriver driver;
    @FindBy(xpath = "(//span[text()='Welcome'])")
    WebElement welcome;

    public VerifySharedStoryPage(WebDriver driver) {

        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public String verify_after_story_shared() {

        return welcome.getText();
    }

}
