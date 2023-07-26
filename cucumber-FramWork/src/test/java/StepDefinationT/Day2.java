package StepDefinationT;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static utiities.ConstantVariable.driver;

public class Day2 {
    WebElement parentElement;
    String price = "";
    String detailsPagePrice = "";
    int k = 1;
    @When("click on Mobile link")
    public void click_on_mobile_link() {

        driver.findElement(By.xpath("//a[text()='Mobile']")).click();

    }

    @Then("store the cost of {string} from the list")
    public void store_the_cost_of_from_the_list(String mobileName) {
      //  WebElement masterElemnet = driver.findElements(By.xpath("//div[@class='category-products']//li[@class='item last']"));
      List<WebElement> elementList =  driver.findElements(By.xpath("//div[@class='category-products']//li[@class='item last']"));
        System.out.println(mobileName);
      for (  WebElement el : elementList){
          if(el.getText().contains(mobileName)){
              parentElement = el;
              System.out.println(" K value in the loop "+k);
              String dynamicXpath = "//span[starts-with(@id, 'product-price-"+k+"')]";
              price = (el.findElement(By.xpath(dynamicXpath))).getText();
              System.out.println("Price "+price);

              break;

          }
          else {
              k++;
              System.out.println(" K value "+k);
          }

         // System.out.println(el.getText());
      }

    }

    @Then("click on image")
    public void click_on() {

        System.out.println("k value in product click "+k);

        parentElement.findElement(By.xpath("//img[starts-with(@id,'product-collection-image-"+k+"')]")).click();

    }

    @Then("store the cost of from the details page")
    public void store_the_cost_of_from_the_details_page() {



       detailsPagePrice = driver.findElement(By.xpath("//div[@class='product-shop']//span[@id='product-price-"+k+"']")).getText();
    }

    @Then("compare the list and details page price for the mobile")
    public void compare_the_list_and_details_page_price_for_the_mobile() {

       // System.out.println(detailsPagePrice +"price "+ price);
        Assert.assertTrue("Price is different ",detailsPagePrice.equals(price));

        driver.quit();


    }

}
