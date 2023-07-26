package TestRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
          features = "src/test/java/FeatureT/day2.feature",
          glue ="StepDefinationT"
          // dryRun = flase
)
public class LoginPageTestRunner {



}
