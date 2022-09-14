package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import resources.ApiResources;
import resources.PayLoadUtils;
import resources.SpecBuilders;

import java.io.FileNotFoundException;

import static io.restassured.RestAssured.given;

public class CreateSalesOrder extends PayLoadUtils {

    RequestSpecification request;
    Response response;

    @Given("sales order payLoad should be ready with country {string} and productId {string}")
    public void sales_order_pay_load_should_be_ready_with(String country, String prdId) {

        try {
            request = given().when().spec(SpecBuilders.requestSpecWithToken(SpecBuilders.token)).body(create_sales_order_body(country, prdId));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    @When("click on {string} with http Post Method")
    public void click_on_with_http_post_method(String resource) {

        ApiResources res = ApiResources.valueOf(resource);
        response = request.when().post(res.getResource()).then().spec(SpecBuilders.responseSpecBuilder).extract().response();

    }

    @Then("Response Body message is {string}")
    public void response_body_message_is(String message) {

//        JsonPath js = new JsonPath(response.body().asString());

        String actualMessage = PayLoadUtils.json_getString(response, "message");
        //   System.out.println(actualMessage);
        Assert.assertTrue(actualMessage.contains(message));
    }

}
