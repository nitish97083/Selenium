package stepDefinations;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import payLoads.AddProductResponse;
import payLoads.Login;
import resources.ApiResources;
import resources.PayLoadUtils;
import resources.SpecBuilders;

import static io.restassured.RestAssured.given;

public class AddProduct extends PayLoadUtils {

    RequestSpecification request;
    Response response;
    Login login;
    AddProductResponse addProductResponse;

    @Given("login payLoad should be with userName and Password")
    public void login_pay_load_should_be_with_user_name_and_password() {

        System.out.println(loginPayLoad().getUserEmail());
        request = given().spec(SpecBuilders.reqSpecBuilder).body(loginPayLoad());
        System.out.println("login with user name ");

    }

    @When("click on {string} with http Post method")
    public void click_on_with_http_post_method(String resource) {

        ApiResources res = ApiResources.valueOf(resource);
        if (resource.contains("Login")) {
            response = request.when().post(res.getResource()).then().spec(SpecBuilders.responseSpecBuilder)
                    .extract().response();
            login = response.as(Login.class); // assigning value into the pojo class
            //    System.out.println(response.asString());
            SpecBuilders.token = login.getToken();
            SpecBuilders.userId = login.getUserId();
        } else {

            response = request.when().post(res.getResource()).then().spec(SpecBuilders.responseSpecBuilder)
                    .extract().response();
            addProductResponse = response.as(AddProductResponse.class);

        }

    }

    @Then("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {

        // System.out.println(" key from  feature" +key +" value is "+value);
        if (key.contains("login")) {
            System.out.println(login.getMessage());
            Assert.assertTrue(login.getMessage().contains(value));

        } else {
            System.out.println(addProductResponse.getMessage());
            Assert.assertTrue(addProductResponse.message.contains(value));
            System.out.println(addProductResponse.getProductId());
        }

    }
//
//    @Given("User authorized to access the api")
//    public void user_authorized_to_access_the_api() {
//
//
//
//    }

    @Given("new Product payload should be ready")
    public void new_product_payload_should_be_ready() {

        request = create_product_body();
    }

    @Test
    public void get_resources() {

        ApiResources res = ApiResources.valueOf("Login");
        System.out.println(res.getResource());
    }


}
