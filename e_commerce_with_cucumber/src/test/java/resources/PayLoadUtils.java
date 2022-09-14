package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import payLoads.CreateOrderBody;
import payLoads.Login;
import payLoads.OrderDetailsPojo;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static resources.SpecBuilders.*;

public class PayLoadUtils {

    public static String json_getString(Response response, String key) {

        JsonPath js = new JsonPath(response.asString());
        return js.get(key).toString();

    }

    public static Integer json_getInt(Response response, String key) {

        JsonPath js = new JsonPath(response.asString());
        return js.getInt(key);

    }

    public Login loginPayLoad() {

        Login login = new Login();
        login.setUserEmail("nkv@gmail.com");
        login.setUserPassword("Abcd@123");

        return login;
    }

    public RequestSpecification create_product_body() {


        System.out.println("User id in create order body method" + userId);
        RequestSpecification reqSpecBuilderWithToken = new RequestSpecBuilder().setBaseUri(base_uri)
                .addHeader("Authorization", token).build();

        return given().spec(reqSpecBuilderWithToken).param("productName", "Laptop")
                .param("productAddedBy", userId)
                .param("productCategory", "Fashion")
                .param("productSubCategory", "Electronic")
                .param("productPrice", 99999)
                .param("productDescription", "Lenovo IdeaPade laptop")
                .param("productFor", "EveryOne")
                .multiPart("productImage", new File("C:/Users/nitis/Documents/mobileCopy/Pictures/test.jpg"));

    }

    public CreateOrderBody create_sales_order_body(String country, String prdId) {

        CreateOrderBody createOrderBody = new CreateOrderBody();
        OrderDetailsPojo orderDetailsPojo = new OrderDetailsPojo();
        orderDetailsPojo.setCountry(country);
        orderDetailsPojo.setProductOrderedId(prdId);
        List<OrderDetailsPojo> list = new ArrayList<>();
        list.add(orderDetailsPojo);

        createOrderBody.setOrders(list);
        return createOrderBody;


    }


}
