package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePageFect {


    WebDriver driver;

    public HomePageFect(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver,5);
        PageFactory.initElements(factory, this);
    }

    @FindBy(xpath = "//a[@role = 'button' and @class = '_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")
    WebElement createNewAccountButton;



    public void createNewAccount() {

       createNewAccountButton.click();


    }
}