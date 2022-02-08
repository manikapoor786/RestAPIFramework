package cucumberOptions;

import org.junit.runner.RunWith;
//import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="src/test/java/features"
		,glue= {"stepDefinitions"}
		,plugin="json:target/jsonReports/cucumber-report.json"
		,tags= "@DeletePlace"
		)

public class TestRunner {

}
