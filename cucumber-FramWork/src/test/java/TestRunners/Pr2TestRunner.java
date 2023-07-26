package TestRunners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/featurePr2/day1.feature",
        glue = "stepDefinationPr2"
        // dryRun = flase
)
public class Pr2TestRunner {


}
