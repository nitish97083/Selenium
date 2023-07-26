package StepDefinationT;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.DriverUtil;

import java.time.Duration;
import java.util.List;

import static utiities.ConstantVariable.driver;
public class AddProductInCart {

    WebElement parentElement;
    int k = 1;

    @When("click on add to cart of the {string} from the list")
    public void clickOnAddToCartOfTheFromTheList(String mobileName) {
        System.out.println(mobileName);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        List<WebElement> elementList = driver.findElements(By.xpath("//div[@class='category-products']//li[@class='item last']"));

        for (WebElement el : elementList) {
            if (el.getText().contains(mobileName)) {
                parentElement = el;
                System.out.println(" K value in the loop " + k);
                driver.findElement(By.xpath("(//div[@class='category-products']//" +
                        "li[@class='item last']//span[text()='Add to Cart'])[" + k + "]")).click();
                break;

            } else {
                k++;
                System.out.println(" K value " + k);
            }
        }
    }


    @Then("Update cart  qty and verify updated qty or error")
    public void updateCartQtyAndVerifyUpdatedQtyOrError() throws InterruptedException {


        WebElement subParent = driver.findElement(By.xpath("//tr[@class='first last odd']//td[@class='product-cart-actions']"));



        WebElement cartBox = subParent.findElement(By.xpath("//input[@class='input-text qty']"));
        System.out.println(cartBox.getAttribute("title") + " Cart qty " + cartBox.getAttribute("value"));
        cartBox.click();
        Thread.sleep(500);
        cartBox.sendKeys("500");
        cartBox.clear();
        cartBox.sendKeys("1000");
        Thread.sleep(100);
        WebElement update = driver.findElement(By.xpath("//button[@class='button btn-update']"));
        System.out.println(update.getAttribute("title"));
        System.out.println(cartBox.getAttribute("title") + " after update Cart qty " + cartBox.getAttribute("value"));
        update.click();
        Thread.sleep(500);

        try {
            WebElement errorEle = driver.findElement(By.xpath("//p[@class='item-msg error']"));
            DriverUtil.waitUntilVisibilityOfElement(driver, errorEle);
            System.out.println(errorEle.getText());
        }
        catch (NoSuchElementException Ex){

            System.out.println("Item added successfully in Cart");

        }
        //The maximum quantity allowed for purchase is 500.
    }

    @And("Empty the cart qty and verify cart should be empty")
    public void emptyTheCartQtyAndVerifyCartShouldBeEmpty() {

            driver.findElement(By.xpath("//button[@id ='empty_cart_button']//span//span")).click();
         String actual = driver.findElement(By.xpath("//div[@class='page-title']//h1")).getText();
        System.out.println(actual);
        Assert.assertTrue(actual.equalsIgnoreCase("Shopping Cart is Empty"));

    }

}
