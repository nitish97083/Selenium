package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/features/CreateOrder.feature",
        glue = "stepDefinations",
        plugin = {"pretty","json:target/cucumber-report.json"}

        //  tags = ("@CreateSO")
        // {"@SmokeTest", "@RegressionTest"}
        //features = "src/test/java/features/Products.feature",
)
public class ETestRunner {

}
