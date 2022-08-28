package ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class HomePageFect {


    WebDriver driver;
    @FindBy(xpath = "//a[@role = 'button' and @class = '_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")
    WebElement createNewAccountButton;

    public HomePageFect(WebDriver driver) {
        this.driver = driver;
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(driver, 5);
        PageFactory.initElements(factory, this);
    }

    @FindBy(id = "email")
    WebElement userNameID;
    @FindBy(id = "pass")
    WebElement passwordID;
    @FindBy(xpath = "//button[starts-with(@id,'u_0_5_')]")
    WebElement loginButtonCSS;
    @FindBy(css = "div._9ay7")
    WebElement wrongPasswordOrEmailCss;

    public void create_new_account() {

        createNewAccountButton.click();
    }

    public void enter_email(String mNumber) {

        userNameID.clear();
        userNameID.sendKeys(mNumber);
    }

    public void enter_password(String passWord) {

        passwordID.clear();
        passwordID.sendKeys(passWord);
    }

    public void click_on_login_button() {

        loginButtonCSS.click();
    }

    public WebElement credential_check() {

        return wrongPasswordOrEmailCss;
    }
}