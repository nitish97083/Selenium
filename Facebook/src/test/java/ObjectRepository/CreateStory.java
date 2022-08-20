package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CreateStory {
     WebDriver driver;
  public   CreateStory(WebDriver driver){

      this.driver = driver;
      PageFactory.initElements(driver,this);
  }

  @FindBy(xpath = "//div[text()='Create a Text Story']")
    WebElement createTextStory;

  @FindBy(xpath = "(//span[text()='Preview'])")
  WebElement waitTilEle;

  @FindBy(xpath = "//textarea[starts-with(@id,'jsc_c')]")
  WebElement insertText;

  @FindBy(xpath = "//div[text()='simple']")
  WebElement selectFont;

  @FindBy(xpath = "(//div[@class='bdao358l k0kqjr44 kj5i7le4 g6da2mms yn3a2qjl b52o6v01 a96hb305 lq84ybu9 hf30pyar' ])[2]/div")
  WebElement listSelectFont;

  @FindBy(xpath = "(//div[@class='alzwoclg o7bt71qk e4ay1f3w' ])//child::div[@class='lvpj5bk4 oveqdiil']")

  List<WebElement> selectBackground;

  @FindBy(xpath = "//span[text()='Share to Story']")
  WebElement shareStory;


    public WebElement create_Text_Story(){

        createTextStory.click();
        return waitTilEle;


    }

    public void insert_Text_Story(String story){
        insertText.click();
        insertText.sendKeys(story);

    }
    public void select_font_Text_Story(String toSelect){

         selectFont.click();
        System.out.println("Text of Font before Try --> "+selectFont.getText());
        try {
            Thread.sleep(500);
            WebElement webElement = driver.findElement(By.xpath("//div[text()='"+toSelect+"']"));
            webElement.click();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


    }
    public void select_backgraund_Text_Story(){

        System.out.println("Background size" +selectBackground.size());
        select_BackGround(selectBackground);


    }
    public void share_story(){

        shareStory.click();


    }

    private void select_BackGround(List<WebElement> selectBackground) {

        selectBackground.get(4).click();
    }

}
