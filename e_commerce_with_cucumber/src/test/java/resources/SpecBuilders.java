package resources;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.*;
import java.util.Properties;

public class SpecBuilders {

    public static String token = "";
    public static String userId = "";
    public static String base_uri = "https://rahulshettyacademy.com";
    public static RequestSpecification reqSpecBuilder = new RequestSpecBuilder().setBaseUri(global_prop()).setContentType(ContentType.JSON).build();
    public static ResponseSpecification responseSpecBuilder = new ResponseSpecBuilder().expectContentType(ContentType.JSON)
            .build();
    static RequestSpecification requestSpecification;

    public static RequestSpecification requestSpecWithToken(String token1) throws FileNotFoundException {

        //Logging filter added by using addFilter to log external file
        if (requestSpecification == null) {
            PrintStream printStream = new PrintStream(new FileOutputStream("ApiLog.txt"));
            requestSpecification = new RequestSpecBuilder().setBaseUri(global_prop()).setContentType(ContentType.JSON)
                    .addHeader("Authorization", token1).addFilter(RequestLoggingFilter.
                            logRequestTo(printStream))
                    .addFilter(ResponseLoggingFilter.logResponseTo(printStream)).build();
            return requestSpecification;
        }
        return requestSpecification;

    }


    public static String global_prop() {

        Properties prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("src/test/java/resources/Global.properties");

            prop.load(fileInputStream);

        } catch (FileNotFoundException e) {


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        // System.out.println(prop.getProperty("Base_Url"));
        return prop.getProperty("Base_Url");
    }
}
