package TestngRun;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
		features="src/test/java/featureFile/Loginclass.feature",
		glue="stepdefinations"
		)
public class runnersTest extends AbstractTestNGCucumberTests {

}
